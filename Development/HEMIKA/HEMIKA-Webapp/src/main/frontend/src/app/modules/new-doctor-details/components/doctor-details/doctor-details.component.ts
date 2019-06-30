//
//import {FormBuilder, FormGroup} from "@angular/forms";
//import {DoctorDtoData} from "../../shared/data/doctor-dto.data";
//import {DoctorService} from "../../shared/doctorService";
//import {Component} from "@angular/core";
//import {UserTypeVtoData} from "../../../creating-users/shared/data/user-type-vto.data";
//import {DepartmentTypeVtoData} from "../../shared/data/department-type-vto.data";
//import {SpecializationVtoData} from "../../shared/data/specialization-vto.data";
//import {LoadService} from "../../../../layout/shared/loadService";
//import {TransService} from "../../../../layout/shared/transService";
//import {Router} from "@angular/router";
//
//@Component({
//  selector: 'doctor-details',
//  templateUrl: './doctor-profile.component.html',
//  styleUrls: ['./doctor-profile.component.scss'],
//  providers : [FormBuilder,DoctorService,LoadService]
//})
//export class DoctorProfileComponent {
//constructor(private formBuilder : FormBuilder ,
//private doctorService:DoctorService,
//private loadService: LoadService) { }
//
//  departType: DepartmentTypeVtoData [] = [];
//  specialType: SpecializationVtoData [] =[];
//  // data = this.transfereService.getData();
//  // constructor(
//  //   private transfereService:TransfereService,
//  //   private router:Router) {
//  //   if(this.data){
//  //     // do whatever needed
//  //   }
//  //   else{
//  //     this.router.navigateByUrl('/sender');
//  //   }
//  // }
//
//ngOnInit() {
//  this.loadService.findDepartType().subscribe(
//res =>{
//  this.departType = res;
//  console.log(this.departType);
//}
//);
//
//  this.loadService.findSpecialType().subscribe(
//res =>{
//  this.specialType = res;
//  console.log(this.specialType);
//}
//);
//}
//
//
//
//  formData : FormGroup = this.formBuilder.group({
//  department :null,
//  mobile :null,
//  specialization :null,
//  grade_year :null,
//  email :null,
//    // personal_pic:null
//  });
//submit():void{
//
//  let docData :DoctorDtoData = new DoctorDtoData();
//  docData.department=this.formData.get('department').value;
//  docData.mobile=this.formData.get('mobile').value;
//  docData.specialization=this.formData.get('specialization').value;
//  docData.grade_year=this.formData.get('grade_year').value;
//  docData.nationalID=this.formData.get('nationalID').value;
//  //docData.personal_pic=this.formData.get('personal_pic').value;
//  console.log(docData);
//  this.doctorService.submit(docData).subscribe(
//res=>{console.log('request is success');},
//err=>{console.log(err);}
//);
//}
//
//
//
//
//}

import {FormBuilder, FormGroup} from "@angular/forms";
import {DoctorDtoData} from "../../shared/data/doctor-dto.data";
import {DoctorService} from "../../shared/doctorService";
import {Component} from "@angular/core";
//import {UserTypeVtoData} from "../../../creating-users/shared/data/user-type-vto.data";
import {DepartmentTypeVtoData} from "../../shared/data/department-type-vto.data";
import {SpecializationVtoData} from "../../shared/data/specialization-vto.data";
import {LoadService} from "../../../../layout/shared/loadService";
//import {TransService} from "../../../../layout/shared/transService";
//import {Router} from "@angular/router";
@Component({
  selector: 'doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.scss'],
  providers : [FormBuilder,DoctorService,LoadService]
})
export class DoctorDetailsComponent {
  constructor(private formBuilder : FormBuilder ,
              private doctorService:DoctorService,
              private loadService: LoadService) { }

  departName: DepartmentTypeVtoData [] = [];
  specialName: SpecializationVtoData [] =[];

  ngOnInit() {
    this.loadService.findDepartType().subscribe(
      res =>{
        this.departName = res;
        console.log(this.departName);
      }
    );

    this.loadService.findSpecialType().subscribe(
      res =>{
        this.specialName = res;
        console.log(this.specialName);
      }
    );
  }

  formData : FormGroup = this.formBuilder.group({
    department :null,
    specialization :null,
    grade_year :null,
    experience :null,

  });
  submit():void{
    let docData :DoctorDtoData = new DoctorDtoData();
    docData.department=this.formData.get('department').value;
    docData.specialization=this.formData.get('specialization').value;
    docData.experience=this.formData.get('experience').value;
    docData.grade_year=this.formData.get('grade_year').value;
    docData.nationalID = localStorage.getItem('nationalID')

    console.log(docData);
    this.doctorService.submit(docData).subscribe(
      res=>{
        console.log('request is success');

      },
      err=>{console.log(err);}
    );
  }




}
