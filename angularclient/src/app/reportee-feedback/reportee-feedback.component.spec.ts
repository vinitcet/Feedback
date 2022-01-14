import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteeFeedbackComponent } from './reportee-feedback.component';

describe('ReporteeFeedbackComponent', () => {
  let component: ReporteeFeedbackComponent;
  let fixture: ComponentFixture<ReporteeFeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReporteeFeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteeFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
