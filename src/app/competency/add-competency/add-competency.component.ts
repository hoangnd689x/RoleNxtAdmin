import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';

@Component({
  selector: 'app-add-competency',
  templateUrl: './add-competency.component.html',
  styleUrls: ['./add-competency.component.css']
})
export class AddCompetencyComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  domains: Domain[];
  domainMap: Map <number, Domain> = new Map();
  addForm: FormGroup;

  ngOnInit() {
    
    this.getAllDomain();

    this.addForm = this.formBuilder.group({
      name: ['', Validators.required],
      category: ['', Validators.required],
      dm: ['-1', Validators.required],
      dmOjb: null,
    });
  }

  getAllDomain(){
    this.apiService.getAllDomain().subscribe(data=>{
      this.domains = data;
      console.log(this.domains);
      this.domains.forEach(val => {
        this.domainMap.set(val.id,val);
      });
    });
  }

  updateDomainObj(val: any){
    console.log(this.domainMap.has(parseInt(val.target.value)));
    this.addForm.get('dmOjb').setValue(this.domainMap.get(parseInt(val.target.value)));
  }

  onSubmit() {
    console.log(this.addForm.value);
    this.apiService.createCompetencies(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['list-com']);
      });
  }

  goBack() {
    this._location.back();
  }

}
