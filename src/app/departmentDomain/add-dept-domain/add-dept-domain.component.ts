import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';
import { Position } from 'src/app/model/position';
import { Organization } from 'src/app/model/organization';

@Component({
  selector: 'app-add-dept-domain',
  templateUrl: './add-dept-domain.component.html',
  styleUrls: ['./add-dept-domain.component.css']
})
export class AddDeptDomainComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  addForm: FormGroup;

  domains: Domain[];
  positions: Position[];
  orgs: Organization[];

  positionMap: Map <number, Position> = new Map();

  ngOnInit() {
    this.getAllDomain();

    this.addForm = this.formBuilder.group({
      name: [''],
      domain: ['-1', Validators.required],
      org: ['-1'],
      position: ['-1', Validators.required],
      positionObj: null,
      competencies: [[], Validators.required],
      responsibilities: ['', Validators.required],
      entryCriteria: ['', Validators.required],
    });
  }

  getAllDomain() {
    this.apiService.getAllDomain().subscribe(data => {
      this.domains = data;
      console.log(this.domains);
    });
  }

  loadOrg(domainId: string) {
    console.log(domainId);
    this.getOrgByDomainId(domainId);
    this.addForm.get('org').setValue('-1');
    this.addForm.get('position').setValue('-1');
  }

  updatePositionObj(val: any){
    console.log(this.positionMap.has(parseInt(val.target.value)));
    this.addForm.get('positionObj').setValue(this.positionMap.get(parseInt(val.target.value)));
  }

  getOrgByDomainId(domainId: string){
    this.apiService.getOrgsByDomainId(domainId).subscribe(data => {
      this.orgs = data;
      console.log(this.orgs);
    });
  }

  loadPosition(orgId: string){
    this.apiService.getPositionsByOrgId(orgId).subscribe(data => {
      this.positions = data;
      console.log(this.positions);
      this.addForm.get('position').setValue('-1');
      this.positions.forEach(val => {
        this.positionMap.set(val.id,val);
      });
    })
  }

  onSubmit() {
    console.log(this.addForm.value);
    this.apiService.createDeptDomain(this.addForm.value)
      .subscribe(data => {
        console.log(data)
        this.router.navigate(['list-deptDomain']);
      });
  }

  goBack() {
    this._location.back();
  }

}
