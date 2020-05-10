import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';
import { Domain } from 'src/app/model/domain';
import { Position } from 'src/app/model/position';
import { Role } from 'src/app/model/role';
import { Organization } from 'src/app/model/organization';
import { Competency } from 'src/app/model/Competency';

@Component({
  selector: 'app-list-role',
  templateUrl: './list-role.component.html',
  styleUrls: ['./list-role.component.css']
})
export class ListRoleComponent implements OnInit {

  constructor(private router: Router, private apiService: ApiService) { }

  domains: Domain[];
  positions: Position[];
  orgs: Organization[];
  competencies: Competency[];

  roles: Role[];

  ngOnInit() {
    this.getAllRoles();
  }

  getAllRoles(){
    this.apiService.getAllRoles().subscribe(data => {
      this.roles = data;
      console.log(this.roles);
    });
  }

  deleteRole(role: Role): void {
    if(confirm("Are you sure you want to delete?"))
    {
      this.apiService.deleteRole(role)
      .subscribe( data => {
        this.getAllRoles();
      })
    }
  };

  editRole(role: Role): void {
    this.router.navigate(['edit-role', role.id]);
  };

  addRole(): void {
    this.router.navigate(['add-role']);
  };

}
