import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { Message } from './message';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private http: HttpClient) { }

  public headers = new HttpHeaders({
    'contentType': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Origin': '*',
    'access-control-allow-headers': 'open'
  });

  getAssessmentByManager(): Observable<any> {
    // return this.http.get("./assets/listAssessmentByManager.json");
    return this.http.get<any>('http://localhost:8080/assessment/listAssessmentByManager/1', { headers: this.headers });
  }

  getAssessmentByUser(): Observable<any> {
    // return this.http.get("./assets/listAssessmentByUser.json");
    return this.http.get<any>('http://localhost:8080/assessment/listAssessmentByUser/3', { headers: this.headers });
  }

  sendFeedbackRequest(payload): Observable<any> {
    return this.http.post<any>('http://localhost:8080/assessment/addFeedbackRequest',  payload);
  }
}
