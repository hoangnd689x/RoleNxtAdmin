import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { ApiService } from 'src/app/service/api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { CareerPath } from 'src/app/model/careerpath';
import { ColorPickerComponent } from 'src/app/color-picker/color-picker.component';


@Component({
  selector: 'app-edit-careerpath',
  templateUrl: './edit-careerpath.component.html',
  styleUrls: ['./edit-careerpath.component.css']
})
export class EditCareerpathComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService,private route: ActivatedRoute, private _location: Location) { }

    editForm: FormGroup;
    cpData: CareerPath;
    cpID: number;

    @ViewChild(ColorPickerComponent, {static: true}) colorPicker : ColorPickerComponent;

  ngOnInit() {

    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      color: ['', Validators.required],
      activate: '',
    });

    this.loadCP()
  }

  loadCP(){
    this.cpID = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getCareerPathById(this.cpID.toString())
      .subscribe(data => {
        this.cpData = data;
        this.colorPicker.color = this.cpData.color;
        this.editForm = this.formBuilder.group({
          id: this.cpData.id,
          name: this.cpData.name,
          color: this.cpData.color,
          activate: this.cpData.activate
        });
      });
  }


  onSubmit(){
    this.editForm.get('color').setValue(this.colorPicker.color);
    this.apiService.updateCareerPath(this.editForm.value)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['list-cp']);
      });
  }

  goBack() {
    this._location.back();
  }

}
