
import {FormBuilder, FormGroup} from "@angular/forms";
import {DoctorDtoData} from "../../shared/data/doctor-dto.data";
import {DoctorService} from "../../shared/doctorService";
import {Component} from "@angular/core";

@Component({
  selector: 'doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.scss'],
  providers : [FormBuilder,DoctorService]
})
export class DoctorDetailsComponent {

  constructor(private formBuilder : FormBuilder ,private doctorService:DoctorService) { }
  ngOnInit() {}
  formData : FormGroup = this.formBuilder.group({
    department :null,
    mobile :null,
    specialization :null,
    grade_year :null,
    email :null,
   // personal_pic:null
  });
  submit():void{

    let docData :DoctorDtoData = new DoctorDtoData();
    docData.department=this.formData.get('department').value;
    docData.mobile=this.formData.get('mobile').value;
    docData.specialization=this.formData.get('specialization').value;
    docData.grade_year=this.formData.get('grade_year').value;
    docData.email=this.formData.get('email').value;
    //docData.personal_pic=this.formData.get('personal_pic').value;
    console.log(docData);
    this.doctorService.submit(docData).subscribe(
      res=>{console.log('request is success');},
      err=>{console.log(err);}
    );
  }




}
