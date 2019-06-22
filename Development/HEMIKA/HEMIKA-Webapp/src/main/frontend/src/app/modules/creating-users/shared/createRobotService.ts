
import {HttpClient} from "@angular/common/http";
import {RobotDtoData} from "./data/robot-dto.data";
import {Injectable} from "@angular/core";
@Injectable()
export class CreateRobotService {
  constructor(private http:HttpClient){}
  submit(data:RobotDtoData){
    return this.http.post("http://localhost:8080/api/robot/create",data);
  }

}
