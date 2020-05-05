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
  selectedCompetenciesText: string = "";
  competenciesTextarea: string = "";
  roleId: number;

  domains: Domain[];
  positions: Position[];
  orgs: Organization[];
  selectedCompetencyObject: Competency;
  competencies: Competency[];
  selectedCompetenciesArray: string[] = [];
  competenciesMap: Map<number, Competency> = new Map();
  selectedCompetencies: Map<number, Competency> = new Map();

  roleData: Role;

  ngOnInit() {

    this.editForm = this.formBuilder.group({
      id: [''],
      domain: ['-1', Validators.required],
      domainObj: null,
      careerPath: [''],
      org: ['-1'],
      orgObj: null,
      position: ['-1', Validators.required],
      positionObj: null,
      domainRole: ['', Validators.required],
      competency: [null, Validators.required],
      competencyObj: [[], Validators.required],
      category: ['', Validators.required],
      kra: ['', Validators.required],
      scope: ['', Validators.required],
      responsibilities: ['', Validators.required],
      industrialRle: ['', Validators.required],
      entryCriteria: ['', Validators.required],
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
          domain: this.roleData.domainObj.id,
          domainObj: this.roleData.domainObj,
          careerPath: this.roleData.careerPath,
          org: this.roleData.orgObj.id,
          orgObj: this.roleData.orgObj,
          position: this.roleData.positionObj.id,
          positionObj: this.roleData.positionObj,
          domainRole: this.roleData.domainRole,
          competency: this.roleData.competency,
          competencyObj: this.roleData.competencyObj,
          category: this.roleData.category,
          kra: this.roleData.kra,
          scope: this.roleData.scope,
          responsibilities: this.roleData.responsibilities,
          industrialRle: this.roleData.industrialRle,
          entryCriteria: this.roleData.entryCriteria
        });
        console.log(this.editForm.value);
        this.getOrgByDomainId(this.roleData.orgObj.id.toString());
        this.apiService.getPositionsByOrgId(this.roleData.domainObj.id.toString()).subscribe(data => {
          this.positions = data;
          console.log(this.positions);
        })
        this.loadSelectedCompetencies(this.roleData.domainObj.id.toString())
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

  loadCompetencyAndOrg(domainId: string) {
    this.getCompetenciesByDomainId(domainId);
    this.getOrgByDomainId(domainId);
    this.editForm.get('org').setValue('-1');
    this.editForm.get('position').setValue('-1');
  }

  loadPosition(orgId: string){
    this.apiService.getPositionsByOrgId(orgId).subscribe(data => {
      this.positions = data;
      console.log(this.positions);
      this.editForm.get('position').setValue('-1');
    })
  }

  getOrgByDomainId(domainId: string){
    this.apiService.getOrgsByDomainId(domainId).subscribe(data => {
      this.orgs = data;
      console.log(this.orgs);
    });
  }

  loadSelectedCompetencies(domainId: string){
    this.apiService.getCompetencyByDomainId(domainId).subscribe(data => {
      this.competencies = data;
      console.log(this.competencies);
      this.competencies.forEach(val => {
        this.competenciesMap.set(val.id, val);
      });
      this.roleData.competencyObj.forEach(val => {
        this.selectedCompetenciesArray.push(val.id.toString());
      })
      
      console.log(this.selectedCompetenciesArray);
      this.selectedCompetenciesArray.forEach(val => {
        this.selectedCompetencies.set(parseInt(val), this.competenciesMap.get(parseInt(val)));
      });
      console.log(this.selectedCompetencies);
    });
  }

  getCompetenciesByDomainId(domainId: string) {
    this.apiService.getCompetencyByDomainId(domainId).subscribe(data => {
      this.competencies = data;
      console.log(this.competencies);
      this.competencies.forEach(val => {
        this.competenciesMap.set(val.id, val);
      });
    });
  }

  updateSelectedCompetency(val: string) {
    this.selectedCompetencyObject = this.competenciesMap.get(parseInt(val));
    console.log(this.selectedCompetencyObject);
  }

  addCompetency() {
    this.selectedCompetencies.set(this.selectedCompetencyObject.id, this.selectedCompetencyObject);
    console.log(Array.from(this.selectedCompetencies.values()));
  }

  getArray() {
    return Array.from(this.selectedCompetencies.values());
  }
  deleteCompetency(competency: Competency) {
    this.selectedCompetencies.delete(competency.id);
  }

  onSubmit() {
    Array.from(this.selectedCompetencies.values()).forEach(val => {
      this.selectedCompetenciesText += val.id + ","
    })
    this.editForm.get('competency').setValue(this.selectedCompetenciesText);
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
