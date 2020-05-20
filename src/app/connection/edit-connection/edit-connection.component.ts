import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from 'src/app/service/api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Organization } from 'src/app/model/organization';
import { Position } from 'src/app/model/position';
import { Domain } from 'src/app/model/domain';
import { Connection } from 'src/app/model/connection';

@Component({
  selector: 'app-edit-connection',
  templateUrl: './edit-connection.component.html',
  styleUrls: ['./edit-connection.component.css']
})
export class EditConnectionComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location, private route: ActivatedRoute) { }

  editForm: FormGroup;
  connectionId: number;
  connectionData: Connection;

  domains: Domain[];
  orgs: Organization[];
  positions: Position[];
  positionMap: Map<number, Position> = new Map();

  ngOnInit() {
    this.loadDomain();
    this.editForm = this.formBuilder.group({
      id: [''],
      domain: ['-1'],
      org: ['-1'],
      orgObj: ['-1', Validators.required],
      source: ['-1', Validators.required],
      sourceIndex: ['-1'],
      target: ['-1', Validators.required],
      targetIndex: ['-1'],
      validate: ['']
    });
    this.loadConnection();
  }

  loadDomain() {
    this.apiService.getAllDomain()
      .subscribe(data => {
        this.domains = data;
        console.log(this.domains);
      });
  }

  loadOrg(domainId: string) {
    this.apiService.getOrgsByDomainId(domainId)
      .subscribe(data => {
        this.orgs = data;
        console.log(this.orgs);
      });
  }

  loadPosition(orgId: string) {
    this.apiService.getPositionsByOrgId(orgId)
      .subscribe(data => {
        this.positions = data;
        console.log(this.positions);
        this.positions.forEach(val => {
          this.positionMap.set(val.id, val);
        });
      });
  }

  loadConnection() {
    this.connectionId = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getConnectionById(this.connectionId.toString())
      .subscribe(data => {
        this.connectionData = data;
        this.editForm = this.formBuilder.group({
          id: this.connectionData.id,
          domain: this.connectionData.orgObj.domainObj.id,
          org: this.connectionData.orgObj.id,
          orgObj: this.connectionData.orgObj,
          sourceIndex: this.connectionData.source.id,
          source: this.connectionData.source,
          targetIndex: this.connectionData.target.id,
          target: this.connectionData.target,
          activate: this.connectionData.activate
        });
        this.loadOrg(this.connectionData.orgObj.domainObj.id.toString())
        this.loadPosition(this.connectionData.orgObj.id.toString())
      });
  }

  updateSource(val: any) {
    console.log(this.positionMap.has(parseInt(val.target.value)));
    this.editForm.get('source').setValue(this.positionMap.get(parseInt(val.target.value)));
  }

  updateTarget(val: any) {
    console.log(this.positionMap.has(parseInt(val.target.value)));
    this.editForm.get('target').setValue(this.positionMap.get(parseInt(val.target.value)));
  }

  onSubmit() {
    this.apiService.updateConnection(this.editForm.value)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['list-con']);
      });
  }

  goBack() {
    this._location.back();
  }

}
