import {Component} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {CreateUserService} from "../../shared/createUserService";
import {UserDtoData} from "../../shared/data/user-dto.data";
import {UserTypeVtoData} from "../../shared/data/user-type-vto.data";
import {LoadService} from "../../../../layout/shared/loadService";

@Component({
  selector: 'create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss'],
  providers : [FormBuilder,CreateUserService,LoadService]
})
export class CreateUserComponent {

  constructor(private formBuilder : FormBuilder ,
              private userService :CreateUserService ,
              private loadSer:LoadService) {

  }
  userType: UserTypeVtoData [] = [];
  ngOnInit() {
    this.loadSer.findUserType().subscribe(
      res => {
        this.userType = res;
        console.log(this.userType);
      }
    );
  }
  formData : FormGroup = this.formBuilder.group({
    nationalID:null,
    type:null,
    firstName :null,
    lastName :null,
    address:null,
    mobileNumber:null,
    userName :null,
    birthDate:null,
    password :null,
    confirmPassword :null,
    email :null

});
  submit():void{
    let userData :UserDtoData = new UserDtoData();
    userData.nationalID=this.formData.get('nationalID').value;
    userData.type=this.formData.get('type').value;
    userData.firstName=this.formData.get('firstName').value;
    userData.lastName=this.formData.get('lastName').value;
    userData.address=this.formData.get('address').value;
    userData.mobileNumber=this.formData.get('mobileNumber').value;
    userData.userName=this.formData.get('userName').value;
    userData.birthDate=this.formData.get('birthDate').value;
    userData.password=this.formData.get('password').value;
    userData.confirmPassword=this.formData.get('confirmPassword').value;
    userData.email=this.formData.get('email').value;

    console.log(userData);
    this.userService.submit(userData).subscribe(
      res=>{console.log('request is success');},
      err=>{console.log(err);}
    );
  }

}
