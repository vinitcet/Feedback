import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { LoginComponent } from './login/login.component';
// import { SeekFeedbackComponent } from './seek-feedback/seek-feedback.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'feedback-home', component: HelloWorldComponent},
  {path: 'logout', component: LoginComponent},
  { path: '**', redirectTo: '' }
  // {path: 'seek-feedback', component: SeekFeedbackComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
