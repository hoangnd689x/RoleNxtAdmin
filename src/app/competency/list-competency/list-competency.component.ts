import { Component, OnInit, Inject } from '@angular/core';
import { Router } from "@angular/router";
import { ApiService } from "../../service/api.service";
import { Competency } from 'src/app/model/Competency';

@Component({
  selector: 'app-list-competency',
  templateUrl: './list-competency.component.html',
  styleUrls: ['./list-competency.component.css']
})
export class ListCompetencyComponent implements OnInit {

  constructor(private router: Router, private apiService: ApiService) { }

  competencies: Competency[];

  ngOnInit() {
    this.getAllCompetencies();
  }

  getAllCompetencies() {
    this.apiService.getAllCompetencies()
      .subscribe(data => {
        this.competencies = data;
        console.log(this.competencies);
      });
  }

  deleteCom(com: Competency): void {
    if (confirm("Are you sure you want to delete?")) {
      this.apiService.deleteCompetency(com.id.toString())
        .subscribe(data => {
          this.getAllCompetencies();
        })
    }
  };

  editCom(com: Competency): void {
    this.router.navigate(['edit-com', com.id]);
  };

  addCom(): void {
    this.router.navigate(['add-com']);
  };

}
