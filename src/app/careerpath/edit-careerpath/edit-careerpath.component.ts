import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { ApiService } from 'src/app/service/api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { CareerPath } from 'src/app/model/careerpath';


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

  ngOnInit() {

    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      color: ['', Validators.required]
    });

    this.loadCP()
  }

  loadCP(){
    this.cpID = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getCareerPathById(this.cpID.toString())
      .subscribe(data => {
        this.cpData = data;
        this.editForm = this.formBuilder.group({
          id: this.cpData.id,
          name: this.cpData.name,
          color: this.cpData.color
        });
      });
  }


  onSubmit(){
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
