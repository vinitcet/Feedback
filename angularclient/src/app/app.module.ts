import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LogoutComponent } from './logout/logout.component';
import { HttpInterceptorService } from './httpInterceptor.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { SeekFeedbackComponent } from './seek-feedback/seek-feedback.component';
import { ReporteeFeedbackComponent } from './reportee-feedback/reportee-feedback.component';
import { FeedbackRequestComponent } from './feedback-request/feedback-request.component';
import { MyFeedbackComponent } from './my-feedback/my-feedback.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';


@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    MenuComponent,
    LoginComponent,
    LogoutComponent,
    SeekFeedbackComponent,
    ReporteeFeedbackComponent,
    FeedbackRequestComponent,
    MyFeedbackComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule,
    FormsModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
