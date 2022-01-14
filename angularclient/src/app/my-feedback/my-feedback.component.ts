import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-my-feedback',
  templateUrl: './my-feedback.component.html',
  styleUrls: ['./my-feedback.component.css']
})
export class MyFeedbackComponent implements OnInit {
  userAssessmentData: any;

  constructor(private feedbackService: FeedbackService
  ) { }

  ngOnInit() {
    this.feedbackService.getAssessmentByUser().subscribe(data => {
      this.userAssessmentData = data
  });
  
  }

}
