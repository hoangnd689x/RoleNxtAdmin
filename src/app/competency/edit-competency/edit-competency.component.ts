import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';
import { Position } from 'src/app/model/position';
import { Competency } from 'src/app/model/Competency';

@Component({
  selector: 'app-edit-competency',
  templateUrl: './edit-competency.component.html',
  styleUrls: ['./edit-competency.component.css']
})
export class EditCompetencyComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location, private route: ActivatedRoute) { }

  domains: Domain[];
  editForm: FormGroup;
  competencyData: Competency;
  compId: number;

  ngOnInit() {

    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      category: ['', Validators.required],
      dm: ['-1', Validators.required],
      dmOjb: ['-1']
    });

    this.getAllDomain();
    this.getComp();
  }

  onUpdate(){
    console.log(this.editForm.value);
    this.apiService.updateCompetency(this.editForm.value)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['list-com']);
      });
  }

  getAllDomain() {
    this.apiService.getAllDomain().subscribe(data => {
      this.domains = data;
      console.log(this.domains);
    });
  }

  getComp() {
    this.compId = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getCompetencyById(this.compId.toString())
      .subscribe(data => {
        this.competencyData = data;
        console.log(this.competencyData);
        this.editForm.setValue({
          id: this.competencyData.id,
          name: this.competencyData.name,
          category: this.competencyData.category,
          dm: this.competencyData.dmOjb.id,
          dmOjb: this.competencyData.dmOjb
        });
        console.log(this.editForm.value);
      });
  }

  goBack() {
    this._location.back();
  }

}
