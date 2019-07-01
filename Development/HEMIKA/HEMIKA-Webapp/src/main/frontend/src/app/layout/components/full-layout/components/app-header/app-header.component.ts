import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-app-header',
  templateUrl: './app-header.component.html'
})
export class AppHeaderComponent implements OnInit {

  currentRoute: string;

  constructor(private router: Router) { }

  ngOnInit() {
    this.currentRoute = this.router.url;
  }

  checkRoute(role: string): boolean {
    if (role == 'doctor') {
      return (this.currentRoute == '/doctor' ||
        this.currentRoute == '/doctor/profile' ||
        this.currentRoute == '/doctor/patients');
    } else if (role == 'patient') {
      return (this.currentRoute == '/patient/profile');
    } else if (role == 'visitor') {
      return (this.currentRoute == '/visitor/profile');
    }

    return false;
  }

}
