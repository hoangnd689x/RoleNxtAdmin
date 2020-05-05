import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';
import {ColorPickerComponent} from "../../color-picker/color-picker.component";

@Component({
  selector: 'app-add-careerpath',
  templateUrl: './add-careerpath.component.html',
  styleUrls: ['./add-careerpath.component.css']
})
export class AddCareerpathComponent implements OnInit, AfterViewInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  addForm: FormGroup;

  @ViewChild(ColorPickerComponent, {static: true}) colorPicker : ColorPickerComponent;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      color: ['', Validators.required]
    });
  }

  ngAfterViewInit(){
    
  }

  onSubmit() {
    this.addForm.get('color').setValue(this.colorPicker.color);
    console.log(this.addForm.value);
    // this.apiService.createCareerPath(this.addForm.value)
    //   .subscribe(data => {
    //     console.log(data)
    //     this.router.navigate(['list-cp']);
    //   });
  }

  goBack() {
    this._location.back();
  }

  logColor()
  {
    console.log("Log");
  }

}
