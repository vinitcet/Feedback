import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeekFeedbackComponent } from './seek-feedback.component';

describe('SeekFeedbackComponent', () => {
  let component: SeekFeedbackComponent;
  let fixture: ComponentFixture<SeekFeedbackComponent>;

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
