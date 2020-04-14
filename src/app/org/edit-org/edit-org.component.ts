import { Component, OnInit , Inject} from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {ApiService} from "../../service/api.service";
import { Organization } from 'src/app/model/organization';
import {Location} from '@angular/common';

@Component({
  selector: 'app-edit-org',
  templateUrl: './edit-org.component.html',
  styleUrls: ['./edit-org.component.css']
})
export class EditOrgComponent implements OnInit {

  org: Organization;
  editForm: FormGroup;
  orgId: number;

  constructor(private formBuilder: FormBuilder,private router: Router, 
    private apiService: ApiService, private route: ActivatedRoute, private _location: Location) { }

  ngOnInit() {

    this.orgId = parseInt(this.route.snapshot.paramMap.get("id"));
    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      domain: ['', Validators.required],
      businessSector: ['', Validators.required]
    });
    this.apiService.getOrgById(+this.orgId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.apiService.updateOrg(this.editForm.value)
      .pipe(first())
      .subscribe(
        orgId => {
          if(orgId === 1) {
            //alert('Org updated successfully.');
            this.router.navigate(['list-org']);
          }else {
            alert(orgId);
          }
        },
        error => {
          alert(error);
        });
  }

  goBack() {
    this._location.back();
  }

}
