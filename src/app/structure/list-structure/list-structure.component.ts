import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ApiService} from "../../service/api.service";
import { Structure } from 'src/app/model/structure';


@Component({
  selector: 'app-list-structure',
  templateUrl: './list-structure.component.html',
  styleUrls: ['./list-structure.component.css']
})
export class ListStructureComponent implements OnInit {

  constructor(private router: Router, private apiService: ApiService) { }

  structures: Structure[];

  ngOnInit() {
    this.getAllStructure();
  }

  getAllStructure(){
    this.apiService.getAllStructures().subscribe(data => {
      this.structures = data;
      console.log(this.structures);
    });
  }

  deleteStructure(structure: Structure): void {
    if(confirm("Are you sure you want to delete?")){
      this.apiService.deleteStructure(structure.id.toString())
      .subscribe( data => {
       this.getAllStructure();
      })
    }
  };

   editStructure(structure: Structure): void {
     this.router.navigate(['edit-structure', structure.id]);
   };

  addStructure(): void {
    this.router.navigate(['add-structure']);
  };
}
