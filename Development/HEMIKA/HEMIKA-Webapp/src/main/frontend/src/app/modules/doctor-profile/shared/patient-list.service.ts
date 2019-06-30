import {Injectable} from "@angular/core";
import {PatientListDto} from "./data/patient-list.dto.data";
import {HttpClient} from "@angular/common/http";
import {patientListVTO} from "./data/patient-list.vto.data";

@Injectable()
export class  PatientListService{
  BASE_URL:string="http://localhost:8080/api/patientList";
  constructor(private http:HttpClient){

  }
  search(data:PatientListDto){
    return this.http.post<patientListVTO[]>(this.BASE_URL+"/search",data);
  }

  findPatientData(data:PatientListDto){
    return this.http.post<patientListVTO[]> (this.BASE_URL+"/findPatient",data );
  }




}
