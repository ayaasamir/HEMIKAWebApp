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
    // return this.http.get<patientListVTO[]> (this.BASE_URL+"/search" );
    // return this.http.get<patientListVTO> (this.BASE_URL+"/find",data);

  }
  // findPatieantData(){
  //   return this.http.get<PatientListDto> (this.BASE_URL+"/findPatientData",);
  //
  // }

  findPatientData(data:PatientListDto){
    return this.http.post<patientListVTO[]> (this.BASE_URL+"/findPatient",data );
  }




}
