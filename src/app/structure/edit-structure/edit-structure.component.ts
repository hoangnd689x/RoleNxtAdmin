import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';
import { Structure } from 'src/app/model/structure';
import { Organization } from 'src/app/model/organization';
import { Domain } from 'src/app/model/domain';
import { Position } from 'src/app/model/position';

@Component({
  selector: 'app-edit-structure',
  templateUrl: './edit-structure.component.html',
  styleUrls: ['./edit-structure.component.css']
})
export class EditStructureComponent implements OnInit {

  editForm: FormGroup;
  structureId: number;

  selectedDep: string;
  selectedDomain: string;
  selectedlvl0: string;
  selectedlvl1: string;
  selectedlvl2: string;
  selectedlvl3: string;
  selectedlvl4: string;
  selectedlvl5: string;
  selectedlvl6: string;
  selectedlvl7: string;

  domains: Domain[];
  positions: Position[];
  orgs: Organization[];
  structureData: Structure;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private route: ActivatedRoute, private _location: Location) { }

  ngOnInit() {

    this.getAllDomain();
    this.getStructure();

    this.editForm = this.formBuilder.group({
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

  getStructure() {
    this.structureId = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getStructureById(this.structureId.toString())
      .subscribe(data => {
        this.structureData = data;
        console.log(this.structureData);
        this.getOrgByDomainId(data.dmObj.id.toString());
        this.getPositionByOrgId(data.orgObj.id.toString());

        this.editForm.setValue({
          id: this.structureData.id,
          org: this.structureData.orgObj.id,
          dm: this.structureData.dmObj.id,
          level0: '-1',
          level1: '-1',
          level2: '-1',
          level3: '-1',
          level4: '-1',
          level5: '-1',
          level6: '-1',
          level7: '-1',
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

        if(this.structureData.level0Obj != null)
        {
          this.editForm.get('level0').setValue(this.structureData.level0Obj.id.toString());
        }
        if(this.structureData.level1Obj != null)
        {
          this.editForm.get('level1').setValue(this.structureData.level1Obj.id.toString());
        }
        if(this.structureData.level2Obj != null)
        {
          this.editForm.get('level2').setValue(this.structureData.level2Obj.id.toString());
        }
        if(this.structureData.level3Obj != null)
        {
          this.editForm.get('level3').setValue(this.structureData.level3Obj.id.toString());
        }
        if(this.structureData.level4Obj != null)
        {
          this.editForm.get('level4').setValue(this.structureData.level4Obj.id.toString());
        }
        if(this.structureData.level5Obj != null)
        {
          this.editForm.get('level5').setValue(this.structureData.level5Obj.id.toString());
        }
        if(this.structureData.level6Obj != null)
        {
          this.editForm.get('level6').setValue(this.structureData.level6Obj.id.toString());
        }
        if(this.structureData.level7Obj != null)
        {
          this.editForm.get('level7').setValue(this.structureData.level7Obj.id.toString());
        }

      });
  }

  onSubmit(){
    console.log(this.editForm.value);
    this.apiService.updateStructure(this.editForm.value)
    .subscribe(data => {
      console.log(data)
      this.router.navigate(['list-structure']);
    });
  }

  getOrgByDomainId(domainId: string) {
    this.apiService.getOrgsByDomainId(domainId)
      .subscribe(data => {
        this.orgs = data;
        console.log(this.domains);
      });
  }

  getAllDomain() {
    this.apiService.getAllDomain().subscribe(data => {
      this.domains = data;
      console.log(this.domains);
    });
  }

  getPositionByOrgId(orgId: string) {
    this.apiService.getPositionsByOrgId(orgId).subscribe(data => {
      this.positions = data;
      console.log(this.positions);
    });
  }

  goBack() {
    this._location.back();
  }

}
