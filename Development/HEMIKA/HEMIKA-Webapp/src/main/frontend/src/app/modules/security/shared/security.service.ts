import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {ConfigParam} from "../../../infrastructure/common/config-param";
import {LoginDTO} from "./data/login-dto.data";
import {AuthUser} from "./data/auth-vto.data";

@Injectable()
export class SecurityService{

  BASE_URL : string = ConfigParam.APP_BASE_URL + "/security";
  constructor(private http: HttpClient){}

  //TODO: Aya - Use Base URL same as /course/shared/course.service
  Login(data:LoginDTO){
    console.log(data);

    return this.http.post<AuthUser>(this.BASE_URL + "/login", data);
  }
}
