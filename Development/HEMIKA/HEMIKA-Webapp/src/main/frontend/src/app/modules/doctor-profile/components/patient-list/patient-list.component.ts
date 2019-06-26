// import { Component, OnInit } from '@angular/core';
// import {FormBuilder, FormGroup, Validators} from "@angular/forms";
// import {PatientListDto} from "./shared/data/patient-list.dto.data";
// import {PatientListService} from "./shared/patient-list.service";
// import {patientListVTO} from "./shared/data/patient-list.vto.data";

import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {PatientListService} from "../../shared/patient-list.service";
import {patientListVTO} from "../../shared/data/patient-list.vto.data";
import {PatientListDto} from "../../shared/data/patient-list.dto.data";

@Component({
  selector: 'patient-list',
  templateUrl:'./patient-list.component.html' ,
  styleUrls: ['./patient-list.component.css'],
  providers:[FormBuilder,PatientListService]
})
export class PatientListComponent implements OnInit {
  patientList:patientListVTO[]=[];
  formData: FormGroup = this.formBuilder.group({
    patientName:null,
    patientStatus: null,
    startDate: null,
    endDate: null
  });

  constructor( private formBuilder:FormBuilder,
               private patientListService :PatientListService) { }

  ngOnInit() {
  }

  solutionOfSearch(data: PatientListDto) {

    this.patientListService.findPatientData(data).subscribe(
      res => {
        this.patientList = res;
        console.log(this.patientList);
      },
      err => {
        console.log(err);
      }
    );
  }





  search(){
    let data: PatientListDto = new PatientListDto();
    data.patientName = this.formData.get('patientName').value;
    data.patientStatus = this.formData.get('patientStatus').value;
    data.startDate = this.formData.get('startDate').value;
    data.endDate = this.formData.get('endDate').value;
    console.log(data);
    // this.patientListService.search(data).subscribe(
    //   res=> {console.log("insert data succeeded");},
    //   err=>{console.log(err);}
    // );

    this.solutionOfSearch(data);





    // this.patientListService.findPatieantData().subscribe(
    //   res=>
    //   {console.log(res);},
    //   err=>{console.log(err);}
    //
    //
    //
    //
    // )
  }
}
