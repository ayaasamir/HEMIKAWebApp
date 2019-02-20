import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
import {HomeComponent} from "./modules/home/home.component";
import {PatientProfileComponent} from "./modules/patient-profile/patient-profile.component";
import {LoginComponent} from "./modules/security/components/login/login.component";

const routes: Routes = [
  {path: '', component: FullLayoutComponent, children:[
      {path:'home', component:HomeComponent},
      {path: 'patient/profile', component: PatientProfileComponent}
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
