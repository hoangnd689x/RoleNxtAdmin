import { Component, OnInit } from '@angular/core';
import { Connection } from 'src/app/model/connection';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-list-connection',
  templateUrl: './list-connection.component.html',
  styleUrls: ['./list-connection.component.css']
})
export class ListConnectionComponent implements OnInit {

  constructor(private router: Router, private apiService: ApiService) { }

connections: Connection[];

  ngOnInit() {
    this.getAllConnection();
  }

  getAllConnection() {
    this.apiService.getAllConnections()
      .subscribe(data => {
        this.connections = data;
      })
  }

  deleteConnection(con: Connection): void {
    if (confirm("Are you sure you want to delete?")) {
      this.apiService.deleteConnection(con)
        .subscribe(data => {
          this.getAllConnection();
        })
    }
  };

  editConnection(con: Connection): void {
    this.router.navigate(['edit-con', con.id]);
  };

  addConnection(): void {
    this.router.navigate(['add-con']);
  };

}
