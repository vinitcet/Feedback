import { Component, OnInit } from '@angular/core';
import { Message } from '../message';
import { HelloWordService } from '../hello-word.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent implements OnInit {

  message: string;
  seekFeedbackCheck: boolean=false;
  reporteeFeedbackCheck: boolean=false;
  feedbackRequestCheck:boolean=false;
  constructor(private helloWorldService: HelloWordService,  private router: Router,
    ) { }

  ngOnInit() {

    console.log("HelloWorldComponent");
    this.helloWorldService.helloWorldService().subscribe( (result) => {
      this.message = result.content;
    });
  }

  seekFeedback(){
    console.log("jhfdk")
    this.seekFeedbackCheck =true
    // this.router.navigate(['/seek-feedback']);

  }
  home(){
    this.seekFeedbackCheck = false
    this.reporteeFeedbackCheck =false
    this.feedbackRequestCheck =false
  }

  reporteeFeedback(){
    this.reporteeFeedbackCheck =true
  }
  feedbackRequest(){
    this.feedbackRequestCheck =true

  }
}
