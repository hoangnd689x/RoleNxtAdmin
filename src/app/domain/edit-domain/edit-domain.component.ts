import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { ApiService } from 'src/app/service/api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Domain } from 'src/app/model/domain';

@Component({
  selector: 'app-edit-domain',
  templateUrl: './edit-domain.component.html',
  styleUrls: ['./edit-domain.component.css']
})
export class EditDomainComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router,
    private apiService: ApiService,private route: ActivatedRoute, private _location: Location) { }

    editForm: FormGroup;
    domainData: Domain;
    domainID: number;

  ngOnInit() {
    this.editForm = this.formBuilder.group({
      id: '',
      name: '',
      activate: '',
    });
    this.loadDomain();
  }

  loadDomain(){
    this.domainID = parseInt(this.route.snapshot.paramMap.get("id"));
    this.apiService.getDomainById(this.domainID.toString())
      .subscribe(data => {
        this.domainData = data;
        this.editForm = this.formBuilder.group({
          id: this.domainData.id,
          name: this.domainData.name,
          activate: this.domainData.activate
        });
      });
  }

  onSubmit(){
    this.apiService.updateDomain(this.editForm.value)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['list-domain']);
      });
  }

  goBack() {
    this._location.back();
  }

}
