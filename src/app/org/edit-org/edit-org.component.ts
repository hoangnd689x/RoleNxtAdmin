import { Component, OnInit, Inject } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { first } from "rxjs/operators";
import { ApiService } from "../../service/api.service";
import { Organization } from 'src/app/model/organization';
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';

@Component({
  selector: 'app-edit-org',
  templateUrl: './edit-org.component.html',
  styleUrls: ['./edit-org.component.css']
})
export class EditOrgComponent implements OnInit {

  org: Organization;
  editForm: FormGroup;
  orgId: number;
  domains: Domain[];

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private route: ActivatedRoute, private _location: Location) { }

  ngOnInit() {

    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      domain: ['-1', Validators.required],
      businessSector: ['', Validators.required],
      domainObj: ['-1']
    });

    this.getAllDomain();
    this.getOrg();
  }

  onSubmit() {
    this.apiService.updateOrg(this.editForm.value)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['list-org']);
      });
  }

  getOrg() {
    this.orgId = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getOrgById(this.orgId.toString())
      .subscribe(data => {
        this.org = data;
        console.log(this.org);
        this.editForm.setValue({
          id: this.org.id,
          name: this.org.name,
          domain: this.org.domainObj.id,
          businessSector: this.org.businessSector,
          domainObj: this.org.domainObj,
        });
        console.log(this.editForm.value);
      });
  }

  getAllDomain() {
    this.apiService.getAllDomain().subscribe(data => {
      this.domains = data;
      console.log(this.domains);
    });
  }

  goBack() {
    this._location.back();
  }

}
