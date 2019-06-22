import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
//import {HomeComponent} from "./modules/home/home.component";
import {PatientProfileComponent} from "./modules/patient-profile/patient-profile.component";
import {LoginComponent} from "./modules/security/components/login/login.component";
import {CreateUserComponent} from "./modules/creating-users/components/create-user/create-user.component";
import {DoctorDetailsComponent} from "./modules/new-doctor-details/components/doctor-details/doctor-details.component";
import {CreateRobotComponent} from "./modules/creating-users/components/create-robot/create-robot.component";
import {HomePageComponent} from "./modules/home/components/home-page/home-page.component";
import {HomePartComponent} from "./modules/home-part/home-part.component";
import {CreateRobotDoneComponent} from "./modules/creating-users/components/create-robot-done/create-robot-done.component";
import {VisitorComponent} from "./modules/visitor/components/new-visitor/visitor.component";

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: '', component: FullLayoutComponent, children:[
      {path:'home', component:HomePageComponent},
      {path:'home/part', component:HomePartComponent},
      {path: 'user/new', component: CreateUserComponent},
      {path: 'patient/profile', component: PatientProfileComponent},
      {path: 'user/doctor', component: DoctorDetailsComponent},
      {path: 'robot/new', component: CreateRobotComponent},
      {path: 'robot/done', component: CreateRobotDoneComponent},
      {path: 'login', component: LoginComponent},
      {path: 'visitor', component: VisitorComponent}

    ]},
  {path:'', component: SimpleLayoutComponent, children:[
      {path: 'login', component: LoginComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
