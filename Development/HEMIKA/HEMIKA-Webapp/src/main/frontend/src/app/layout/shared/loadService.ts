import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {UserTypeVtoData} from "../../modules/creating-users/shared/data/user-type-vto.data";

@Injectable()
export class LoadService {
  constructor(private http :HttpClient){}

  findUserType(){
    return this.http.get<UserTypeVtoData[]>("http://localhost:8080/api/load/userType");
  }

}
