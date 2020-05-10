import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';
import { Position } from 'src/app/model/position';
import { Organization } from 'src/app/model/organization';
import { CareerPath } from 'src/app/model/careerpath';

@Component({
  selector: 'app-edit-position',
  templateUrl: './edit-position.component.html',
  styleUrls: ['./edit-position.component.css']
})
export class EditPositionComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location, private route: ActivatedRoute) { }

  editForm: FormGroup;
  positionData: Position;
  positionId: Number;
  orgs: Organization[];
  cps: CareerPath[];

  ngOnInit() {
    this.editForm = this.formBuilder.group({
      id: [''],
      organization: ['-1', Validators.required],
      careerPath: ['-1', Validators.required],
      organizationObj: null,
      careerpathObj: null,
      name: ['', Validators.required],
      cluster: [0, Validators.required],
      activate: ''
    });

    this.getOrg();
    this.getCPs();
    this.getPosition();
  }

  onUpdate() {
    console.log(this.editForm.value);
    this.apiService.updatePosition(this.editForm.value)
    .subscribe(data => {
      console.log(data);
      this.router.navigate(['list-position']);
    });
  }

  getOrg() {
    this.apiService.getOrgs().subscribe(data => {
      this.orgs = data;
      console.log(this.orgs);
    });
  }

  getCPs() {
    this.apiService.getAllCareerPaths()
      .subscribe(data => {
        this.cps = data;
        console.log(this.cps);
      });
  }

  getPosition() {
    this.positionId = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getPositionById(this.positionId.toString())
      .subscribe(data => {
        this.positionData = data;
        console.log(this.positionData);
        this.editForm.setValue({
          id: this.positionData.id,
          organization: this.positionData.organizationObj.id,
          name: this.positionData.name,
          organizationObj: this.positionData.organizationObj,
          careerPath: this.positionData.careerpathObj.id,
          careerpathObj: this.positionData.careerpathObj,
          cluster: this.positionData.cluster,
          activate: this.positionData.activate,
        });
        console.log(this.editForm.value);
      });
  }

  goBack() {
    this._location.back();
  }

}
