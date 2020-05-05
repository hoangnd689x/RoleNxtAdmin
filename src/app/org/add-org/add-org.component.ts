import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';

@Component({
  selector: 'app-add-org',
  templateUrl: './add-org.component.html',
  styleUrls: ['./add-org.component.css']
})
export class AddOrgComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService, private _location: Location) { }

  domains: Domain[];
  addForm: FormGroup;
  domainMap: Map <number, Domain> = new Map();

  ngOnInit() {

    this.getAllDomain();

    this.addForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      domain: ['-1', Validators.required],
      businessSector: ['', Validators.required],
      domainObj: ['-1', Validators.required]
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
    this.addForm.get('domainObj').setValue(this.domainMap.get(parseInt(val.target.value)));
  }

  onSubmit() {
    console.log(this.addForm.value);
    this.apiService.createOrg(this.addForm.value)
      .subscribe(data => {
        console.log(data)
        this.router.navigate(['list-org']);
      });
  }

  goBack() {
    this._location.back();
  }

}
