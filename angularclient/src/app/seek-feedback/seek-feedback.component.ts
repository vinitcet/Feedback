import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';
declare var $: any;

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
    var isnum
    var num = +(this.accessorId);
    isnum = (num == num) ? true : false
    console.log(isnum)
    const payload = {
      "employeeId": this.feedbackService.userdata.id,
      // accessor: this.accessorId,
      // "accessorName": this.accessorId,
      "feedbackMessage": this.feedbackMessage
    }
    var accessor = isnum ? "accessorId" : "accessorName"
    this.accessorId = isnum ? Number(this.accessorId) : this.accessorId
    payload[accessor] = this.accessorId

    this.feedbackService.sendFeedbackRequest(payload).subscribe(data => {
      console.log(payload)
      console.log(data);
      this.successFbRequest = true;
      this.successMessage = 'Feedback Request has been sent Successfully !'
      this.accessorId = ''
      this.feedbackMessage = ''
    }, () => {
      this.failFbRequest = true;
      this.successFbRequest = false;
      this.errorMessage = 'Failed to send feedback request'
    });
  }
}
