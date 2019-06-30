import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
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
import {CreateVisitorComponent} from "./modules/visitor/components/create-visitor/create-visitor.component";
import {PatientListComponent} from "./modules/doctor-profile/components/patient-list/patient-list.component";
import {CreateUserDoneComponent} from "./modules/creating-users/components/create-user-done/create-user-done.component";
import {DoctorProfileComponent} from "./modules/doctor-profile/components/doctor-profile/doctor-profile.component";
import {PatientsComponent} from "./modules/doctor-profile/components/doctor-profile/components/patients/patients.component";
import {ProfileComponent} from "./modules/doctor-profile/components/doctor-profile/components/profile/profile.component";
import {PatientDetailsComponent} from "./modules/patient-profile/components/patient-details/patient-details.component";

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {
    path: '', component: FullLayoutComponent, children: [
      {path: 'home', component: HomePageComponent},
      {path: 'home/part', component: HomePartComponent},
      {path: 'user/new', component: CreateUserComponent},
      {path: 'patient/profile', component: PatientProfileComponent},
      {path: 'user/doctor', component: DoctorDetailsComponent},
      {path: 'robot/new', component: CreateRobotComponent},
      {path: 'robot/done', component: CreateRobotDoneComponent},
      {path: 'login', component: LoginComponent},
      {path: 'visitor', component: VisitorComponent},
      {path: 'patientlist', component:PatientListComponent},
      {path: "Create/Visitor", component:CreateVisitorComponent},
      {path: 'user/done', component: CreateUserDoneComponent},
      {
        path: 'doctor', component: DoctorProfileComponent, children: [
          {path: 'patients', component: PatientsComponent},
          {path: 'profile', component: ProfileComponent}
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
