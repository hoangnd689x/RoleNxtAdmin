import { Component, OnInit } from '@angular/core';
import { DepartmentDomain } from 'src/app/model/departmentDomain';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-list-dept-domain',
  templateUrl: './list-dept-domain.component.html',
  styleUrls: ['./list-dept-domain.component.css']
})
export class ListDeptDomainComponent implements OnInit {

  deptDomains: DepartmentDomain[];

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    this.getData();

  }

  getData() {
    this.apiService.getAllDeptDomain()
      .subscribe(data => {
        this.deptDomains = data;
        console.log(this.deptDomains);
      });
  }

  delete(deptDomain: DepartmentDomain): void {
    if (confirm("Are you sure you want to delete?")) {
      this.apiService.deleteDeptDomain(deptDomain)
        .subscribe(data => {
          this.getData();
        })
    }
  };

  edit(deptDomain: DepartmentDomain): void {
    this.router.navigate(['edit-deptDomain', deptDomain.id]);
  };

  add(): void {
    this.router.navigate(['add-deptDomain']);
  };

}
