import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from 'src/app/service/api.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { Organization } from 'src/app/model/organization';
import { Position } from 'src/app/model/position';
import { Domain } from 'src/app/model/domain';

@Component({
  selector: 'app-add-connection',
  templateUrl: './add-connection.component.html',
  styleUrls: ['./add-connection.component.css']
})
export class AddConnectionComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  addForm: FormGroup;
  domains: Domain[];
  orgs: Organization[];
  orgMap: Map <number, Organization> = new Map();
  positions: Position[];
  positionMap: Map <number, Position> = new Map();

  ngOnInit() {
    this.loadDomain();
    this.addForm = this.formBuilder.group({
      domain: ['-1'],
      org: ['-1'],
      orgObj: ['-1', Validators.required],
      source: ['-1', Validators.required],
      sourceIndex: ['-1'],
      target: ['-1', Validators.required],
      targetIndex: ['-1'],
    });
  }

  loadDomain(){
    this.apiService.getAllDomain()
    .subscribe(data => {
      this.domains = data;
      console.log(this.domains);
    });
  }

  loadOrg(domainId: string){
    this.apiService.getOrgsByDomainId(domainId)
    .subscribe(data => {
      this.orgs = data;
      console.log(this.orgs);
      this.orgs.forEach(val => {
        this.orgMap.set(val.id,val);
      });
    });
    this.addForm.get('org').setValue('-1');
  }

  loadPosition(orgId: string){
    this.apiService.getPositionsByOrgId(orgId)
    .subscribe(data => {
      this.positions = data;
      console.log(this.positions);
      this.positions.forEach(val => {
        this.positionMap.set(val.id,val);
      });
    });
    this.addForm.get('sourceIndex').setValue('-1');
    this.addForm.get('targetIndex').setValue('-1');
  }

  updateOrgObj(val: any){
    console.log(this.orgMap.has(parseInt(val.target.value)));
    this.addForm.get('orgObj').setValue(this.orgMap.get(parseInt(val.target.value)));
    this.loadPosition(val.target.value);
  }

  updateSource(val: any){
    console.log(this.positionMap.has(parseInt(val.target.value)));
    this.addForm.get('source').setValue(this.positionMap.get(parseInt(val.target.value)));
  }

  updateTarget(val: any){
    console.log(this.positionMap.has(parseInt(val.target.value)));
    this.addForm.get('target').setValue(this.positionMap.get(parseInt(val.target.value)));
  }

  onSubmit() {
    console.log(this.addForm.value);
    this.apiService.createConnection(this.addForm.value)
      .subscribe(data => {
        console.log(data)
        this.router.navigate(['list-con']);
      });
  }

  goBack() {
    this._location.back();
  }

}
