import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';
import { Organization } from 'src/app/model/organization';
import { CareerPath } from 'src/app/model/careerpath';


@Component({
  selector: 'app-add-position',
  templateUrl: './add-position.component.html',
  styleUrls: ['./add-position.component.css']
})
export class AddPositionComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  orgs: Organization[];
  cps: CareerPath[];
  addForm: FormGroup;
  orgMap: Map <number, Organization> = new Map();
  cpMap: Map <number, CareerPath> = new Map();

  ngOnInit() {

    this.getOrgs();
    this.getCPs();
    this.addForm = this.formBuilder.group({
      organization: ['-1', Validators.required],
      careerPath: ['-1', Validators.required],
      organizationObj: null,
      careerpathObj: null,
      name: ['', Validators.required],
      cluster: [0, Validators.required]
    });
  }

  onSubmit() {
    console.log(this.addForm.value);
    this.apiService.createPosition(this.addForm.value)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['list-position']);
      });
  }

  getOrgs() {
    this.apiService.getOrgs()
      .subscribe(data => {
        this.orgs = data;
        console.log(this.orgs);
        this.orgs.forEach(val => {
          this.orgMap.set(val.id,val);
        });
      });
  }

  getCPs() {
    this.apiService.getAllCareerPaths()
      .subscribe(data => {
        this.cps = data;
        console.log(this.cps);
        this.cps.forEach(val => {
          this.cpMap.set(val.id,val);
        });
      });
  }

  updateCPObj(val: any){
    console.log(this.cpMap.has(parseInt(val.target.value)));
    this.addForm.get('careerpathObj').setValue(this.cpMap.get(parseInt(val.target.value)));
  }

  updateOrgObj(val: any){
    console.log(this.orgMap.has(parseInt(val.target.value)));
    this.addForm.get('organizationObj').setValue(this.orgMap.get(parseInt(val.target.value)));
  }

  goBack() {
    this._location.back();
  }

}
