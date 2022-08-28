import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';
import { Observable } from 'rxjs';
import { startWith, debounceTime, distinctUntilChanged, switchMap, map } from 'rxjs/operators';
import { FormControl } from '@angular/forms';

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
  allEmployeeList: any = [];
  myControl = new FormControl();
  options = [];
  filteredOptions: Observable<any>;

  constructor(private feedbackService: FeedbackService
  ) {
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      debounceTime(400),
      distinctUntilChanged(),
      switchMap(val => {
        return this.filter(val || '')
      })
    )
  }

  filter(val: string): Observable<any> {
    return this.feedbackService.getAllUsers().pipe(map(response => response.filter(option => {
      return option.fullName.toLowerCase().includes(val.toLowerCase())
    })))
  }

  ngOnInit() {
    console.log('inside init')
    this.feedbackService.getAllUsers().subscribe(data => {
      console.log(data);
      this.allEmployeeList = data
    });
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
    var accessor = isnum ? "accessorId" : "accessorEmail"
    this.accessorId = isnum ? Number(this.accessorId) : this.accessorId
    payload[accessor] = this.accessorId

    this.feedbackService.sendFeedbackRequest(payload).subscribe(data => {
      console.log(payload)
      console.log(data);
      this.successFbRequest = true;
      this.successMessage = 'Feedback Request has been sent Successfully !'
      this.accessorId = ''
      this.feedbackMessage = ''
      $('#viewMemberModal').show();
      setTimeout(function () {
        $('#viewMemberModal').hide();

      }, 3000);
    }, () => {
      this.failFbRequest = true;
      this.successFbRequest = false;
      this.errorMessage = 'Failed to send feedback request';
      $('#viewMemberModal').show();
      setTimeout(function () {
        $('#viewMemberModal').hide();
      }, 2000);
    });
  }
}
