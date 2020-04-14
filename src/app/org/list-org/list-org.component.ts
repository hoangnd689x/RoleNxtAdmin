import { Component, OnInit , Inject} from '@angular/core';
import {Router} from "@angular/router";
import {User} from "../../model/user.model";
import {ApiService} from "../../service/api.service";
import { Organization } from 'src/app/model/organization';

@Component({
  selector: 'app-list-org',
  templateUrl: './list-org.component.html',
  styleUrls: ['./list-org.component.css']
})
export class ListOrgComponent implements OnInit {

  orgs: Organization[] = [];

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    
    this.apiService.getOrgs()
      .subscribe( data => {
        this.orgs = data;
        console.log(data);
        console.log(this.orgs);
      });
  }

  deleteOrg(org: Organization): void {
    this.apiService.deleteOrg(org.id)
      .subscribe( data => {
        this.orgs = this.orgs.filter(u => u !== org);
      })
  };

   editOrg(org: Organization): void {
     this.router.navigate(['edit-org', org.id]);
   };

  addOrg(): void {
    this.router.navigate(['add-org']);
  };
}
