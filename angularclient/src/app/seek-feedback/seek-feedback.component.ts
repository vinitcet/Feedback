import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-seek-feedback',
  templateUrl: './seek-feedback.component.html',
  styleUrls: ['./seek-feedback.component.css']
})
export class SeekFeedbackComponent implements OnInit {
  seekFeedbackresponse: any;
  accessorId: any;
  feedbackMessage: string;
  successMessage: any;
  successFbRequest: boolean;
  failFbRequest: boolean;
  errorMessage: string;
  constructor(private feedbackService: FeedbackService
  ) { }

  ngOnInit() {
  }


  sendRequest() {
    const payload = {
      "employeeId": 1,
      "accessorId": this.accessorId,
      "feedbackMessage": this.feedbackMessage
    }
    this.feedbackService.sendFeedbackRequest(payload).subscribe(data => { console.log(payload)
      console.log(data);
      this.successFbRequest = true;
      this.successMessage = data
      this.accessorId = ''
      this.feedbackMessage = ''
    }, () => {
        this.failFbRequest = true;
        this.successFbRequest = false;
        this.errorMessage = 'Failed to send feedback request'
      });      
  }
}
