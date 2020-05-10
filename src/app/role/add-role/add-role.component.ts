import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';
import { Position } from 'src/app/model/position';
import { Competency } from 'src/app/model/Competency';
import { Organization } from 'src/app/model/organization';

@Component({
  selector: 'app-add-role',
  templateUrl: './add-role.component.html',
  styleUrls: ['./add-role.component.css']
})
export class AddRoleComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  addForm: FormGroup;
  selectedCompetenciesText: string = "";
  competenciesTextarea: string = "";

  domains: Domain[];
  positions: Position[];
  orgs: Organization[];
  selectedCompetencyObject: Competency;
  competencies: Competency[];
  competenciesMap: Map<number, Competency> = new Map();
  selectedCompetencies: Map<number, Competency> = new Map();
  //selectedCompetencies: Competency[];

  positionMap: Map <number, Position> = new Map();

  ngOnInit() {
    this.getAllDomain();

    this.addForm = this.formBuilder.group({
      domain: ['-1', Validators.required],
      org: ['-1'],
      position: ['-1', Validators.required],
      positionObj: null,
      domainRole: ['', Validators.required],
      category: ['', Validators.required],
      competencies: [[], Validators.required],
      kra: ['', Validators.required],
      scope: ['', Validators.required],
      responsibilities: ['', Validators.required],
      industrialRole: ['', Validators.required],
      entryCriteria: ['', Validators.required],
    });
  }

  getAllDomain() {
    this.apiService.getAllDomain().subscribe(data => {
      this.domains = data;
      console.log(this.domains);
    });
  }

  loadCompetencyAndOrg(domainId: string) {
    console.log(domainId);
    this.getCompetenciesByDomainId(domainId);
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
    if(this.selectedCompetencyObject)
    {
      this.selectedCompetencies.set(this.selectedCompetencyObject.id, this.selectedCompetencyObject);
      console.log(Array.from(this.selectedCompetencies.values()));
    }
  }

  getArray() {
    return Array.from(this.selectedCompetencies.values());
  }
  deleteCompetency(competency: Competency) {
    this.selectedCompetencies.delete(competency.id);
  }

  onSubmit() {
    // Array.from(this.selectedCompetencies.values()).forEach(val => {
    //   this.selectedCompetenciesText += val.id + ","
    // })
    this.addForm.get('competencies').setValue(Array.from(this.selectedCompetencies.values()));
    console.log(this.addForm.value);
    this.apiService.createRole(this.addForm.value)
      .subscribe(data => {
        console.log(data)
        this.router.navigate(['list-role']);
      });
  }

  goBack() {
    this._location.back();
  }

}
