// import {Component, OnInit, ViewChild} from '@angular/core';
// import {FormBuilder, FormGroup} from "@angular/forms";
// import {Contact} from "../../shared/data/contacts";
// import {PatientListDto} from "../../../patient-list/shared/data/patient-list.dto.data";
// import {CreateVisitorService} from "../../shared/create-visitor.service";
// //import {PatientListService} from "../../../patient-list/shared/patient-list.service";
// import {patientListVTO} from "../../../patient-list/shared/data/patient-list.vto.data";
// import {PatientListService} from "../../../patient-list/shared/patient-list.service";
import {Component, OnInit, ViewChild} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {patientListVTO} from "../../../doctor-profile/shared/data/patient-list.vto.data";
import {Contact} from "../../shared/data/contacts";
import {CreateVisitorService} from "../../shared/create-visitor.service";

@ViewChild('input')
@Component({
  selector: 'create-visitor',
  templateUrl: './create-visitor.component.html',
  styleUrls: ['./create-visitor.component.scss'],
  providers:[FormBuilder,CreateVisitorService]
})
export class CreateVisitorComponent implements OnInit {
  patientList:patientListVTO[]=[];
  errorFlag:boolean=false;
  formData: FormGroup = this.formBuilder.group({
    patientName:null
  });
  private input;
  contacts:Array<Contact>;
  constructor( private formBuilder:FormBuilder,
               private CreateVisitorService :CreateVisitorService) {
    this.contacts = [];

  }

  ngOnInit() {
  }
  addText(){
    let patientName:string=this.formData.get('patientName').value;
    this.CreateVisitorService.findPatientData(patientName).subscribe(
      res => {
        console.log(res);
        if(res[0]){
          let contact = new Contact(res[0].patientName);
          this.contacts.push(contact);
          this.errorFlag=false;
        }else {
          this.errorFlag=true;
        }

      },
      err => {
        console.log(err);
      }

    );

  }












}
