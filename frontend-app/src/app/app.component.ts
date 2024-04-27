import {Component, OnInit} from '@angular/core';
import {CandidateService} from "./candidate.service";
import {Candidate} from "./models/candidate";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'frontend-app';

  candidateList:Candidate[]=[];

  constructor(private service:CandidateService) {
  }

  ngOnInit(): void {
    this.getAllCandidateListFromServer();
  }

  getAllCandidateListFromServer(){
    this.service.getAllCandidates().subscribe({
      next:response=>{
        this.candidateList=response;
      },
      error:err => {
        console.log("There is some problem with  api calling.. "+err.status);
      }
    })
  };

}
