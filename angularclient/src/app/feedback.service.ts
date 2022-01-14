import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { Message } from './message';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private http: HttpClient) { }

  getAssessmentByManager() : Observable<any>{
    console.log('inside service')
    // return this.http.get<Message>('http://localhost:8080/api/v1/greeting');
    return this.http.get("./assets/listAssessmentByManager.json"); 
    return this.http.get<any>('http://localhost:8080/assessment/listAssessmentByManager/1');
  }

}
