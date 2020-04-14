import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ApiService} from "../../service/api.service";
import {Location} from '@angular/common';

@Component({
  selector: 'app-add-org',
  templateUrl: './add-org.component.html',
  styleUrls: ['./add-org.component.css']
})
export class AddOrgComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, 
    private apiService: ApiService, private _location: Location) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      domain: ['', Validators.required],
      businessSector: ['', Validators.required]
    });

  }

  onSubmit() {
    this.apiService.createOrg(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-org']);
      });
  }

  goBack() {
    this._location.back();
  }

}
