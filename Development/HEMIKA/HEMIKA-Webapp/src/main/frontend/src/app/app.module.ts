import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {LayoutComponent} from "./layout/layout.component";
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
import { AppHeaderComponent } from './layout/components/full-layout/components/app-header/app-header.component';
import { AppFooterComponent } from './layout/components/full-layout/components/app-footer/app-footer.component';
import { HomeComponent } from './modules/home/home.component';
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { PatientDetailsComponent } from './modules/patient-profile/components/patient-details/patient-details.component';
import { PatientProfileComponent } from './modules/patient-profile/patient-profile.component';
import { PatientHistoryComponent } from './modules/patient-profile/components/patient-history/patient-history.component';
import { LoginComponent } from './modules/security/components/login/login.component';
import {AuthInterceptor} from "./infrastructure/interceptor/auth.interceptor";
import {LocalStorageService} from "./infrastructure/services/local-storage.service";

@NgModule({
  declarations: [
    LayoutComponent,
    FullLayoutComponent, SimpleLayoutComponent, AppHeaderComponent, AppFooterComponent, HomeComponent, PatientDetailsComponent,
    PatientProfileComponent, PatientHistoryComponent, LoginComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, ReactiveFormsModule, CommonModule,
    AppRoutingModule
  ],
  providers: [
    LocalStorageService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  bootstrap: [LayoutComponent]
})
export class AppModule { }
