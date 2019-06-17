import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {LayoutComponent} from "./layout/layout.component";
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
import { AppHeaderComponent } from './layout/components/full-layout/components/app-header/app-header.component';
import { AppFooterComponent } from './layout/components/full-layout/components/app-footer/app-footer.component';
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { PatientDetailsComponent } from './modules/patient-profile/components/patient-details/patient-details.component';
import { PatientProfileComponent } from './modules/patient-profile/patient-profile.component';
import { PatientHistoryComponent } from './modules/patient-profile/components/patient-history/patient-history.component';
import { LoginComponent } from './modules/security/components/login/login.component';
import {CreateUserComponent} from "./modules/creating-users/components/create-user/create-user.component";
import {DoctorDetailsComponent} from "./modules/new-doctor-details/components/doctor-details/doctor-details.component";
//import {ContainerPartComponent} from "./modules/home/components/container-part/container-part.component";
//import {FooterPartComponent} from "./modules/home/components/footer-part/footer-part.component";
//import {HeaderPartComponent} from "./modules/home/components/header-part/header-part.component";
// import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
// import {AppComponent} from "./app.component";
import {CreateRobotComponent} from "./modules/creating-users/components/create-robot/create-robot.component";
import {HomePageComponent} from "./modules/home/components/home-page/home-page.component";
import {AppComponent} from "./app.component";
import {ContainerPartComponent} from "./modules/home-part/container-part/container-part.component";
import {FooterPartComponent} from "./modules/home-part/footer-part/footer-part.component";
import {HeaderPartComponent} from "./modules/home-part/header-part/header-part.component";
import {HomePartComponent} from "./modules/home-part/home-part.component";
import {HomeComponent} from "./modules/home/home.component";
//import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    LayoutComponent,
    FullLayoutComponent, SimpleLayoutComponent, AppHeaderComponent,
    AppFooterComponent, PatientDetailsComponent,AppComponent,HomeComponent,
    PatientProfileComponent, PatientHistoryComponent, LoginComponent,
    AppHeaderComponent, AppFooterComponent,HomePageComponent,
    ContainerPartComponent,FooterPartComponent,HeaderPartComponent,HomePartComponent,
    CreateUserComponent, CreateRobotComponent, DoctorDetailsComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, ReactiveFormsModule, CommonModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [LayoutComponent]
})
export class AppModule { }
