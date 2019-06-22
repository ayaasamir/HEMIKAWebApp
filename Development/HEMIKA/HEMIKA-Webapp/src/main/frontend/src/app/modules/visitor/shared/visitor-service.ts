import {VisitorDtoData} from "./data/visitor-dto.data";
import {Injectable} from "@angular/core";
//import {HttpClient} from "@angular/common/http";
@Injectable()
export class VisitorService {
  constructor(){}
  //constructor(private  http :HttpClient){}
  add(visitorData :VisitorDtoData){
    //return this.http.post("http://localhost:8080/api/visitor/add",visitorData);
  }

}
