import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';
import { Domain } from 'src/app/model/domain';
import { Position } from 'src/app/model/position';
import { Location } from '@angular/common';
import { Organization } from 'src/app/model/organization';
import { DepartmentDomain } from 'src/app/model/departmentDomain';

@Component({
  selector: 'app-edit-dept-domain',
  templateUrl: './edit-dept-domain.component.html',
  styleUrls: ['./edit-dept-domain.component.css']
})
export class EditDeptDomainComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router,
    private apiService: ApiService, private _location: Location) { }

    editForm: FormGroup;
    id: number;

  domains: Domain[];
  positions: Position[];
  orgs: Organization[];

  deptDomainData: DepartmentDomain;

  ngOnInit() {
    this.editForm = this.formBuilder.group({
      id: [''],
      name: [''],
      domain: ['-1', Validators.required],
      org: ['-1'],
      position: ['-1', Validators.required],
      positionObj: null,
      competencies: [[], Validators.required],
      responsibilities: ['', Validators.required],
      entryCriteria: ['', Validators.required],
      activate: ''
    });

    this.getAllDomain();
    this.getData();
  }

  getData() {
    this.id = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getDeptDomainById(this.id.toString())
      .subscribe(data => {
        this.deptDomainData = data;
        console.log(this.deptDomainData);
        this.editForm.setValue({
          id: this.deptDomainData.id,
          name: this.deptDomainData.name,
          domain: this.deptDomainData.positionObj.organizationObj.domainObj.id,
          org: this.deptDomainData.positionObj.organizationObj.id,
          position: this.deptDomainData.positionObj.id,
          positionObj: this.deptDomainData.positionObj,
          competencies: this.deptDomainData.competencies,
          responsibilities: this.deptDomainData.responsibilities,
          entryCriteria: this.deptDomainData.entryCriteria,
          activate: this.deptDomainData.activate
        });

        //console.log(this.editForm.value);
        this.getOrgByDomainId(this.deptDomainData.positionObj.organizationObj.domainObj.id.toString());
        this.apiService.getPositionsByOrgId(this.deptDomainData.positionObj.organizationObj.id.toString()).subscribe(data => {
          this.positions = data;
          console.log(this.positions);
        })
      });
  }

  getAllDomain() {
    this.apiService.getAllDomain().subscribe(data => {
      this.domains = data;
      console.log(this.domains);
    });
  }

  loadPosition(orgId: string) {
    this.apiService.getPositionsByOrgId(orgId).subscribe(data => {
      this.positions = data;
      console.log(this.positions);
      this.editForm.get('position').setValue('-1');
    })
  }

  getOrgByDomainId(domainId: string) {
    this.apiService.getOrgsByDomainId(domainId).subscribe(data => {
      this.orgs = data;
      console.log(this.orgs);
    });
  }

  onSubmit() {
    console.log(this.editForm.value);
    this.apiService.updateDeptDomain(this.editForm.value)
      .subscribe(data => {
        console.log(data)
        this.router.navigate(['list-deptDomain']);
      });
  }

  goBack() {
    this._location.back();
  }

}
