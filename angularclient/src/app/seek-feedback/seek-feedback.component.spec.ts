import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import React, { useState } from 'react';
import { Typeahead } from 'react-bootstrap-typeahead';
import ReactDOM from 'react-dom';


import { SeekFeedbackComponent } from './seek-feedback.component';
import 'react-bootstrap-typeahead/css/Typeahead.css';


describe('SeekFeedbackComponent', () => {
  let component: SeekFeedbackComponent;
  let fixture: ComponentFixture<SeekFeedbackComponent>;
  const [selected, setSelected] = useState([]);

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeekFeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeekFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
