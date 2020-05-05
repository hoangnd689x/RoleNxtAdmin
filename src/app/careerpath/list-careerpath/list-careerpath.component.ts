import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { Router } from '@angular/router';
import { CareerPath } from 'src/app/model/careerpath';

@Component({
  selector: 'app-list-careerpath',
  templateUrl: './list-careerpath.component.html',
  styleUrls: ['./list-careerpath.component.css']
})
export class ListCareerpathComponent implements OnInit {

  constructor(private router: Router, private apiService: ApiService) { }

  cps: CareerPath[];

  ngOnInit() {
    this.getAllCP();
  }

  getAllCP() {
    this.apiService.getAllCareerPaths()
      .subscribe(data => {
        this.cps = data;
      })
  }

  deleteCP(cp: CareerPath): void {
    if (confirm("Are you sure you want to delete?")) {
      this.apiService.deleteCareerPath(cp.id.toString())
        .subscribe(data => {
          this.getAllCP();
        })
    }
  };

  editCP(cp: CareerPath): void {
    this.router.navigate(['edit-cp', cp.id]);
  };

  addCP(): void {
    this.router.navigate(['add-cp']);
  };

}
