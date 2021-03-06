import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Message } from './message';

@Injectable({
  providedIn: 'root'
})
export class HelloWordService {

  constructor(private http: HttpClient) { }

  helloWorldService() {
    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('feedback' + ':' + 'password') });
    return this.http.get<any>('http://localhost:8080/api/v1/greeting');
  }
}
