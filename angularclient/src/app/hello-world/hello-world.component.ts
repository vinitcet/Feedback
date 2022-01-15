import { Component, OnInit } from '@angular/core';
import { Message } from '../message';
import { HelloWordService } from '../hello-word.service';
import { Router } from '@angular/router';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent implements OnInit {

  message: string;
  seekFeedbackCheck: boolean = false;
  reporteeFeedbackCheck: boolean = false;
  feedbackRequestCheck: boolean = false;
  myFeedbackCheck: boolean = false;

  constructor(private helloWorldService: HelloWordService, private router: Router,private feedbackService: FeedbackService
  ) { }

  ngOnInit() {

    console.log("HelloWorldComponent");
    this.helloWorldService.helloWorldService().subscribe((result) => {
      this.message = ` Hello ${result.firstName}`;
      this.feedbackService.saveUserdata( this.message);
    });
  }

  seekFeedback() {
    this.home()
    this.seekFeedbackCheck = true
  }
  home() {
    this.seekFeedbackCheck = false
    this.reporteeFeedbackCheck = false
    this.feedbackRequestCheck = false
    this.myFeedbackCheck = false
  }

  reporteeFeedback() {
    this.home()
    this.reporteeFeedbackCheck = true
  }
  feedbackRequest() {
    this.home()
    this.feedbackRequestCheck = true
  }
  myFeedback() {
    this.home()
    this.myFeedbackCheck = true
  }
}
