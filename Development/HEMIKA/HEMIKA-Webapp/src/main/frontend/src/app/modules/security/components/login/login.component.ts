import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginDTO} from "../../shared/data/login-dto.data";
import {AuthUser} from "../../shared/data/auth-vto.data";
import {SecurityService} from "../../shared/security.service";
import {LocalStorageService} from "../../../../infrastructure/services/local-storage.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  providers: [FormBuilder, SecurityService]
})

export class LoginComponent implements OnInit {

  authVto: AuthUser;
  formData: FormGroup = this.formBuilder.group({
    username: [null, [Validators.required, Validators.maxLength(25), Validators.minLength(5)]],
    password: [null, [Validators.required, Validators.minLength(8)]]
  });

  constructor(private formBuilder: FormBuilder,
              private userService: SecurityService,
              private localStorageService: LocalStorageService) { }

  ngOnInit() {
  }

  login(){
    let data: LoginDTO = new LoginDTO();
    data.username = this.formData.get('username').value;
    data.password = this.formData.get('password').value;

    if(this.formData.valid){
      this.userService.Login(data).subscribe(
        res=>{
          this.authVto = res;
          // console.log("Success");
          // console.log(this.authVto);
          this.localStorageService.setAuthUser(this.authVto);
        },
        err => {console.log(err);}
      );
    }else{
      console.log("Invalid user name or/and password");
    }
  }

}
