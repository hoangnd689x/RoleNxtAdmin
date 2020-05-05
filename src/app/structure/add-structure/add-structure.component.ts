import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';
import { Organization } from 'src/app/model/organization';
import { Domain } from 'src/app/model/domain';
import { Position } from 'src/app/model/position';

@Component({
  selector: 'app-add-structure',
  templateUrl: './add-structure.component.html',
  styleUrls: ['./add-structure.component.css']
})
export class AddStructureComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  addForm: FormGroup;
  domains: Domain[];
  positions: Position[];
  orgs: Organization[];

  ngOnInit() {

    this.getAllDomain();

    this.addForm = this.formBuilder.group({
      id: [''],
      org: ['-1', Validators.required],
      dm: ['-1', Validators.required],
      level0: ['-1', Validators.required],
      level1: ['-1', Validators.required],
      level2: ['-1', Validators.required],
      level3: ['-1', Validators.required],
      level4: ['-1', Validators.required],
      level5: ['-1', Validators.required],
      level6: ['-1', Validators.required],
      level7: ['-1', Validators.required],
      orgObj: null,
      dmObj: null,
      level0Obj: null,
      level1Obj: null,
      level2Obj: null,
      level3Obj: null,
      level4Obj: null,
      level5Obj: null,
      level6Obj: null,
      level7Obj: null,
    });
  }

  getAllDomain() {
    this.apiService.getAllDomain().subscribe(data => {
      this.domains = data;
      console.log(this.domains);
    });
  }

  loadPositions(orgId: string){
    this.getPositionByOrgId(orgId)
  }

  getPositionByOrgId(orgId: string) {
    this.apiService.getPositionsByOrgId(orgId).subscribe(data => {
      this.positions = data;
      console.log(this.positions);
    });
  }

  loadOrgs(domainId: string) {
    this.getOrgs(domainId)
  }

  getOrgs(domainId: string) {
    this.apiService.getOrgsByDomainId(domainId).subscribe(data => {
      this.orgs = data;
      console.log(this.orgs);

      this.addForm.get('org').setValue('-1');
      this.addForm.get('level0').setValue('-1');
      this.addForm.get('level1').setValue('-1');
      this.addForm.get('level2').setValue('-1');
      this.addForm.get('level3').setValue('-1');
      this.addForm.get('level4').setValue('-1');
      this.addForm.get('level5').setValue('-1');
      this.addForm.get('level6').setValue('-1');
      this.addForm.get('level7').setValue('-1');
    });
  }

  onSubmit() {
    console.log(this.addForm.value);
    this.apiService.createStructure(this.addForm.value)
    .subscribe(data => {
      console.log(data)
      this.router.navigate(['list-structure']);
    });
  }

  goBack() {
    this._location.back();
  }
}
