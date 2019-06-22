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

@Component({
  selector: 'create-robot-done',
  templateUrl: './create-robot-done.component.html',
  styleUrls: ['./create-robot-done.component.css'],
  //providers : [FormBuilder,CreateUserService,LoadService]
})
export class CreateRobotDoneComponent {
  constructor() {}

  ngOnInit() {}

}
// export class CreateUserComponent {
//
//   constructor(private formBuilder : FormBuilder ,
//               private userService :CreateUserService ,
//               private loadSer:LoadService) {
//
//   }
//   userType: UserTypeVtoData [] = [];
//   ngOnInit() {
//     this.loadSer.findUserType().subscribe(
//       res => {
//         this.userType = res;
//         console.log(this.userType);
//       }
//     );
//   }
//   formData : FormGroup = this.formBuilder.group({
//     firstName :null,
//     lastName :null,
//     userName :null,
//     password :null,
//     confirmPassword :null,
//     type:null
//   });
// submit():void{
//
//     this.userService.submit(userData).subscribe(
//       res=>{console.log('request is success');},
//       err=>{console.log(err);}
//     );
//   }
//
//
//
//
// }
