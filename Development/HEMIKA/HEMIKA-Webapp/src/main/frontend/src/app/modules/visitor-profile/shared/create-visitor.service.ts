import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {patientListVTO} from "../../doctor-profile/shared/data/patient-list.vto.data";
// import {patientListVTO} from "../../patient-list/shared/data/patient-list.vto.data";
// import {PatientListDto} from "../../patient-list/shared/data/patient-list.dto.data";

@Injectable()
export class  CreateVisitorService{
  BASE_URL:string="http://localhost:8080/api/create/visitor";
  constructor(private http:HttpClient){

  }

  findPatientData(name:string){
    return this.http.post<patientListVTO[]> (this.BASE_URL+"/findPatient",name );
  }




}
