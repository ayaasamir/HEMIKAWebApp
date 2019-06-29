import { Injectable } from '@angular/core';
import {AuthUser} from "../../modules/security/shared/data/auth-vto.data";

@Injectable()
export class LocalStorageService {

  static AUTH_USER:string = "Hakeim-Auth-User"

  constructor() { }

  setAuthUser(user: AuthUser){
    let json:string = JSON.stringify(user);
    localStorage.setItem(LocalStorageService.AUTH_USER, json);
  }

  getCurrentUser(): AuthUser{
    let json: string = localStorage.getItem(LocalStorageService.AUTH_USER);
    let authUser: AuthUser = JSON.parse(json);
    return authUser;
  }
}
