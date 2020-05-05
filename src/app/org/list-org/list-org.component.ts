import { Component, OnInit, Inject } from '@angular/core';
import { Router } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Organization } from 'src/app/model/organization';

@Component({
  selector: 'app-list-org',
  templateUrl: './list-org.component.html',
  styleUrls: ['./list-org.component.css']
})
export class ListOrgComponent implements OnInit {

  orgs: Organization[];

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    this.getOrgs();

  }

  getOrgs() {
    this.apiService.getOrgs()
      .subscribe(data => {
        this.orgs = data;
        console.log(this.orgs);
      });
  }

  deleteOrg(org: Organization): void {
    if (confirm("Are you sure you want to delete?")) {
      this.apiService.deleteOrg(org.id.toString())
        .subscribe(data => {
          this.getOrgs();
        })
    }
  };

  editOrg(org: Organization): void {
    this.router.navigate(['edit-org', org.id]);
  };

  addOrg(): void {
    this.router.navigate(['add-org']);
  };
}
