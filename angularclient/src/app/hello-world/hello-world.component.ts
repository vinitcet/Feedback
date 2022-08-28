import { Component, OnInit } from '@angular/core';
import { Message } from '../message';
import { HelloWordService } from '../hello-word.service';
import { Router } from '@angular/router';
import { FeedbackService } from '../feedback.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent implements OnInit {

  message: string;
  imageContent: any;
  seekFeedbackCheck: boolean = false;
  reporteeFeedbackCheck: boolean = false;
  feedbackRequestCheck: boolean = false;
  myFeedbackCheck: boolean = false;

  constructor(private helloWorldService: HelloWordService, private router: Router, private feedbackService: FeedbackService, private sanitizer: DomSanitizer
  ) { }

  ngOnInit() {

    console.log("HelloWorldComponent");
    this.helloWorldService.helloWorldService().subscribe((result) => {
      this.message = ` Logged As:  ${result.firstName} | ${result.position}  `;

      let objectURL = 'data:image/jpeg;base64,' + result.imageContent;
      this.imageContent = this.sanitizer.bypassSecurityTrustUrl(objectURL);

      if (result.imageContent != null) {
        let objectURL = 'data:image/jpeg;base64,' + result.imageContent;
        this.imageContent = this.sanitizer.bypassSecurityTrustUrl(objectURL);
      } else {
        if (result.gender === "Male") {
          this.imageContent = "assets/male.jpg";
        }
        else {
          this.imageContent = "assets/female.jpg";
        }
      }

      this.feedbackService.saveUserdata(result);
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
