// import {Component} from "@angular/core";
// import {FormBuilder, FormGroup} from "@angular/forms";
// import {CreateUserService} from "../../shared/createUserService";
// import {UserDtoData} from "../../shared/data/user-dto.data";
// import {UserTypeVtoData} from "../../shared/data/user-type-vto.data";
// import {LoadService} from "../../../../layout/shared/loadService";
//
// @Component({
//   selector: 'create-user',
//   templateUrl: './create-user.component.html',
//   styleUrls: ['./create-user.component.scss'],
//   providers : [FormBuilder,CreateUserService,LoadService]
// })
import {Component} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {CreateRobotService} from "../../shared/createRobotService";
import {RobotDtoData} from "../../shared/data/robot-dto.data";
import {UserTypeVtoData} from "../../shared/data/user-type-vto.data";
import {HospitalNameVtoData} from "../../shared/data/hospital-name-vto.data";
import {LoadService} from "../../../../layout/shared/loadService";

@Component({
    selector: 'create-robot',
    templateUrl: './create-robot.component.html',
    styleUrls: ['./create-robot.component.scss'],
    providers : [FormBuilder,CreateRobotService,LoadService]
})
export class CreateRobotComponent {
  // constructor() {}
  constructor(private formBuilder : FormBuilder ,private loadSer : LoadService,
              private robotService :CreateRobotService ) {}

  hospitalName: HospitalNameVtoData [] = [];
  ngOnInit() {
    this.loadSer.findHospitalName().subscribe(
      res =>{
        this.hospitalName = res;
        console.log(this.hospitalName);

      }
    )
  }


  formData : FormGroup= this.formBuilder.group({
    robotName :null,
    hospitalID :null,
    location_X :null,
    location_Y :null
});
submit():void{
  let robotData :RobotDtoData = new RobotDtoData();
  robotData.robotName=this.formData.get('robotName').value;
  robotData.hospitalID=this.formData.get('hospitalID').value;
  robotData.location_X=this.formData.get('location_X').value;
  robotData.location_Y=this.formData.get('location_Y').value;
  console.log(robotData);
  this.robotService.submit(robotData).subscribe(
    res=>{console.log('request is success');},
    err=>{console.log(err);}
  );
}

}

