import {UserDtoData} from "./data/user-dto.data";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
@Injectable()
export class CreateUserService {
  constructor(private http:HttpClient){}
  submit(data:UserDtoData){
    return this.http.post("http://localhost:8080/api/user/create",data);
  }
}
