
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {DoctorDtoData} from "./data/doctor-dto.data";
@Injectable()
export class DoctorService {
  constructor(private http:HttpClient){}
  submit(data:DoctorDtoData){
    return this.http.post("http://localhost:8080/api/userDoctor/createDoc",data);
  }
}
