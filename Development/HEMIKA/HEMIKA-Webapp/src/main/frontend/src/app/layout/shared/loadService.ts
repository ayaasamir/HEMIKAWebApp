import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {UserTypeVtoData} from "../../modules/creating-users/shared/data/user-type-vto.data";
import {DepartmentTypeVtoData} from "../../modules/new-doctor-details/shared/data/department-type-vto.data";
import {SpecializationVtoData} from "../../modules/new-doctor-details/shared/data/specialization-vto.data";
import {HospitalNameVtoData} from "../../modules/creating-users/shared/data/hospital-name-vto.data";

@Injectable()
export class LoadService {
  constructor(private http :HttpClient){}

  findUserType(){
    return this.http.get<UserTypeVtoData[]>("http://localhost:8080/api/load/userType");
  }
  findDepartType(){
    return this.http.get<DepartmentTypeVtoData[]>("http://localhost:8080/api/load/departType");
  }
  findSpecialType(){
    return this.http.get<SpecializationVtoData[]>("http://localhost:8080/api/load/specialType");
  }
  findHospitalName(){
    return this.http.get<HospitalNameVtoData[]>("http://localhost:8080/api/load/hospitalName");
  }


}
