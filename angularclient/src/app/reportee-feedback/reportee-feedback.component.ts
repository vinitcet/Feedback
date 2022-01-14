import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-reportee-feedback',
  templateUrl: './reportee-feedback.component.html',
  styleUrls: ['./reportee-feedback.component.css']
})
export class ReporteeFeedbackComponent implements OnInit {
  managerAssessmentData: any;

  constructor(
    private feedbackService: FeedbackService
  ) { }

  ngOnInit() {
    console.log('inside init')
    this.feedbackService.getAssessmentByManager().subscribe(data => {
      console.log(data);
      this.managerAssessmentData = data
  });
  }

}
