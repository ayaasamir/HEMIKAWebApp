import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {LayoutComponent} from "./layout/layout.component";
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
import {AppHeaderComponent} from './layout/components/full-layout/components/app-header/app-header.component';
import {AppFooterComponent} from './layout/components/full-layout/components/app-footer/app-footer.component';
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {PatientDetailsComponent} from './modules/patient-profile/components/patient-details/patient-details.component';
import {PatientProfileComponent} from './modules/patient-profile/patient-profile.component';
import {PatientHistoryComponent} from './modules/patient-profile/components/patient-history/patient-history.component';
import {LoginComponent} from './modules/security/components/login/login.component';
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
import {CreateRobotDoneComponent} from "./modules/creating-users/components/create-robot-done/create-robot-done.component";
// import {DocHeaderComponent} from "./modules/doctor-profile/components/doc-header/doc-header.component";
// import {DocSideBarComponent} from "./modules/doctor-profile/components/doc-side-bar/doc-side-bar.component";
import {VisitorComponent} from "./modules/visitor/components/new-visitor/visitor.component";
import {DoctorProfileComponent} from "./modules/doctor-profile/components/doctor-profile/doctor-profile.component";
import {PatientsComponent} from "./modules/doctor-profile/components/doctor-profile/components/patients/patients.component";
import {ProfileComponent} from "./modules/doctor-profile/components/doctor-profile/components/profile/profile.component";

// import {PatientListComponent} from "./modules/doctor-profile/components/patient-list/patient-list.component";
import {PatientListComponent} from "./modules/doctor-profile/components/doctor-profile/components/patient-list/patient-list.component";
import {CreateVisitorComponent} from "./modules/visitor/components/create-visitor/create-visitor.component";
import {CreateUserDoneComponent} from "./modules/creating-users/components/create-user-done/create-user-done.component";
import {VisitorProfileComponent} from "./modules/visitor/components/visitor-profile/visitor-profile.component";
import {AboutComponent} from "./modules/home/components/about/about.component";
import {ContactComponent} from "./modules/home/components/contact/contact.component";
import {ServicesComponent} from "./modules/home/components/services/services.component";
import {DoctorsComponent} from "./modules/home/components/doctors/doctors.component";
import {NewsComponent} from "./modules/home/components/news/news.component";
//import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    LayoutComponent,
    DoctorProfileComponent,
    PatientsComponent,
    ProfileComponent,
    FullLayoutComponent,
    SimpleLayoutComponent,
    AppHeaderComponent,
    AppFooterComponent,
    PatientDetailsComponent,
    AppComponent,
    HomeComponent,
    PatientProfileComponent,
    PatientHistoryComponent,
    LoginComponent,
    AppHeaderComponent,
    AppFooterComponent,
    HomePageComponent,
    ContainerPartComponent,
    FooterPartComponent,
    HeaderPartComponent,
    HomePartComponent,
    CreateUserComponent,
    CreateRobotComponent,
    CreateRobotDoneComponent,
    DoctorDetailsComponent,
    VisitorComponent,
    PatientListComponent,
    CreateVisitorComponent,
    CreateUserDoneComponent,
    VisitorProfileComponent,
    AboutComponent,
    ContactComponent,
    ServicesComponent,
    DoctorsComponent,
    NewsComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, ReactiveFormsModule, CommonModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [LayoutComponent]
})
export class AppModule {
}
