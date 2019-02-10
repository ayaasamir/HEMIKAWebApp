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
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    LayoutComponent,
    FullLayoutComponent, SimpleLayoutComponent, AppHeaderComponent, AppFooterComponent, HomeComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, ReactiveFormsModule, CommonModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [LayoutComponent]
})
export class AppModule { }
