import { Component, OnInit } from '@angular/core';
import { Domain } from 'src/app/model/domain';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-list-domain',
  templateUrl: './list-domain.component.html',
  styleUrls: ['./list-domain.component.css']
})
export class ListDomainComponent implements OnInit {

  constructor(private router: Router, private apiService: ApiService) { }

  domains: Domain[];

  ngOnInit() {
    this.getAllDomain();
  }

  getAllDomain() {
    this.apiService.getAllDomain()
      .subscribe(data => {
        this.domains = data;
      })
  }

  deleteDomain(dm: Domain): void {
    if (confirm("Are you sure you want to delete?")) {
      this.apiService.deleteDomain(dm)
        .subscribe(data => {
          this.getAllDomain();
        })
    }
  };

  editDomain(dm: Domain): void {
    this.router.navigate(['edit-domain', dm.id]);
  };

  addDomain(): void {
    this.router.navigate(['add-domain']);
  };

}
