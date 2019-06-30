import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patient-profile',
  templateUrl: './patient-profile.component.html',
  styleUrls: ['./patient-profile.component.scss']
})
export class PatientProfileComponent implements OnInit {

  name: string;
  age: number;
  date: string;
  status: string;
  doctor: string ;

  constructor() { }

  ngOnInit() {
    this.name = " Aya";
    this.age = 23;
    this.date = " 2019-02-21";
    this.status = " Good";
    this.doctor = " Abd Allah";
  }

}
