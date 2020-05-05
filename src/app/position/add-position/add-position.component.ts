import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';
import { Organization } from 'src/app/model/organization';


@Component({
  selector: 'app-add-position',
  templateUrl: './add-position.component.html',
  styleUrls: ['./add-position.component.css']
})
export class AddPositionComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  orgs: Organization[];
  addForm: FormGroup;
  orgMap: Map <number, Domain> = new Map();

  ngOnInit() {

    this.getOrgs();
    this.addForm = this.formBuilder.group({
      id: [''],
      organization: ['-1', Validators.required],
      name: ['', Validators.required],
      organizationObj: ['-1']
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

  updateOrgObj(val: any){
    console.log(this.orgMap.has(parseInt(val.target.value)));
    this.addForm.get('organizationObj').setValue(this.orgMap.get(parseInt(val.target.value)));
  }

  goBack() {
    this._location.back();
  }

}
