import { Injectable } from '@angular/core';
import {Candidate} from "./models/candidate";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  //private apiUrl='http://52.66.205.94:30415'
  private apiUrl='http://codeadiction.com'
 // private apiUrl = process.env.BACKEND_URL;
  constructor(private http:HttpClient) { }


  getAllCandidates():Observable<Candidate[]>{
    console.log("Root Url....!!");
    console.log(`${this.apiUrl}`);
    return this.http.get<Candidate[]>(`${this.apiUrl}/candidate/all`)
  };


  // getHeaders():HttpHeaders{
  //   const headers:HttpHeaders = new HttpHeaders();
  //   headers.set("Authorization", "Bearer "+token);
  //   return headers;
  // }

}
