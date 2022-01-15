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
  feedbackMessage: any;
  showMessage: boolean = false;

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

  requestFb(){
    const payload = {
      feedback : this.feedbackMessage
    }
    this.feedbackService.requestFeedback(payload, this.viewFeedbackData.id).subscribe(data => {
      console.log(data);
      
      $('#viewMemberModal').modal('hide');
      this.showMessage =true
    });
  }

}
