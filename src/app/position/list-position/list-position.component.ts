import { Component, OnInit } from '@angular/core';
import { Domain } from 'src/app/model/domain';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';
import { Position } from 'src/app/model/position';
import { Organization } from 'src/app/model/organization';

@Component({
  selector: 'app-list-position',
  templateUrl: './list-position.component.html',
  styleUrls: ['./list-position.component.css']
})
export class ListPositionComponent implements OnInit {

  constructor(private router: Router, private apiService: ApiService) { }

  positions: Position[];

  ngOnInit() {
    this.getAllPosition();
  }

  deletePosition(position: Position): void {
    if(confirm("Are you sure you want to delete?")){
    this.apiService.deletePosition(position.id.toString())
      .subscribe( data => {
        this.getAllPosition();
      })
    }
  };

  getAllPosition() {
    this.apiService.getAllPositions()
      .subscribe(data => {
        this.positions = data;
        console.log(this.positions);
      });
  }

   editPosition(position: Position): void {
     this.router.navigate(['edit-position', position.id]);
   };

  addPosition(): void {
    this.router.navigate(['add-position']);
  };

}
