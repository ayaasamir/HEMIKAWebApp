import { Component, OnInit } from '@angular/core';
import {SecurityService} from "../security/shared/security.service";
import {LocalStorageService} from "../../infrastructure/services/local-storage.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers:[SecurityService, LocalStorageService]
})
export class HomeComponent implements OnInit {

  constructor(private securitySevice: SecurityService,
              private localStorageService: LocalStorageService) { }

  ngOnInit() {
    console.log(this.localStorageService.getCurrentUser());
  }

  OnClikc(){
    this.securitySevice.test().subscribe(err=>{});
  }

}
