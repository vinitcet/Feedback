import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';
declare var $: any;
@Component({
  selector: 'app-feedback-request',
  templateUrl: './feedback-request.component.html',
  styleUrls: ['./feedback-request.component.css']
})
export class FeedbackRequestComponent implements OnInit {
  assigneeAssessmentData: any;
  viewFeedbackData: any;

  constructor(private feedbackService: FeedbackService
  ) { }

  ngOnInit() {
    this.feedbackService.getAssessmentByAssignee().subscribe(data => {
      console.log(data);
      this.assigneeAssessmentData = data
    });
  }

  view(data) { console.log(data)
    this.viewFeedbackData = data ;
    $('#viewMemberModal').modal('show');
  }

}
