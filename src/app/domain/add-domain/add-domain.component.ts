import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';

@Component({
  selector: 'app-add-domain',
  templateUrl: './add-domain.component.html',
  styleUrls: ['./add-domain.component.css']
})
export class AddDomainComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

    addForm: FormGroup;


  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
    });

  }

  onSubmit() {
    console.log(this.addForm.value);
    this.apiService.createDomain(this.addForm.value)
      .subscribe(data => {
        console.log(data)
        this.router.navigate(['list-domain']);
      });
  }

  goBack() {
    this._location.back();
  }

}
