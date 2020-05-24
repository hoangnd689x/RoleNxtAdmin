import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';
import { Domain } from 'src/app/model/domain';
import { Competency } from 'src/app/model/Competency';
import { Position } from 'src/app/model/position';
import { Role } from 'src/app/model/role';
import { Location } from '@angular/common';
import { Organization } from 'src/app/model/organization';

@Component({
  selector: 'app-edit-role',
  templateUrl: './edit-role.component.html',
  styleUrls: ['./edit-role.component.css']
})
export class EditRoleComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  editForm: FormGroup;
  roleId: number;

  domains: Domain[];
  positions: Position[];
  orgs: Organization[];

  roleData: Role;

  ngOnInit() {

    this.editForm = this.formBuilder.group({
      id: [''],
      domain: ['-1', Validators.required],
      org: ['-1'],
      position: ['-1', Validators.required],
      positionObj: null,
      domainRole: ['', Validators.required],
      competencies: [[], Validators.required],
      category: ['', Validators.required],
      kra: ['', Validators.required],
      scope: ['', Validators.required],
      responsibilities: ['', Validators.required],
      industrialRole: ['', Validators.required],
      entryCriteria: ['', Validators.required],
      activate: ''
    });

    this.getAllDomain();
    this.getRole();


  }

  getRole() {
    this.roleId = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getRoleById(this.roleId.toString())
      .subscribe(data => {
        this.roleData = data;
        console.log(this.roleData);
        this.editForm.setValue({
          id: this.roleData.id,
          domain: this.roleData.positionObj.organizationObj.domainObj.id,
          //careerPath: this.roleData.careerPath,
          org: this.roleData.positionObj.organizationObj.id,
          position: this.roleData.positionObj.id,
          positionObj: this.roleData.positionObj,
          domainRole: this.roleData.domainRole,
          competencies: this.roleData.competencies,
          category: this.roleData.category,
          kra: this.roleData.kra,
          scope: this.roleData.scope,
          responsibilities: this.roleData.responsibilities,
          industrialRole: this.roleData.industrialRole,
          entryCriteria: this.roleData.entryCriteria,
          activate: this.roleData.activate
        });

        //console.log(this.editForm.value);
        this.getOrgByDomainId(this.roleData.positionObj.organizationObj.domainObj.id.toString());

        this.apiService.getPositionsByOrgId(this.roleData.positionObj.organizationObj.id.toString()).subscribe(data => {
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

  // loadCompetency(domainId: string) {
  //   this.getCompetenciesByDomainId(domainId);
  //   this.selectedCompetencies.clear();
  // }

  loadOrg(domainId: string) {
    this.getOrgByDomainId(domainId);
    this.editForm.get('org').setValue('-1');
    this.editForm.get('position').setValue('-1');
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
    this.apiService.updateRole(this.editForm.value)
      .subscribe(data => {
        console.log(data)
        this.router.navigate(['list-role']);
      });
  }

  goBack() {
    this._location.back();
  }

}
