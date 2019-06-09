import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {LocalStorageService} from "../services/local-storage.service";
import {AuthUser} from "../../modules/security/shared/data/auth-vto.data";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor(private localStorageService: LocalStorageService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    // req = req.clone({
    //   setHeaders: {
    //     Authorization: `Bearer ` + localStorage.getItem('token')
    //   }
    // });
    let authUser: AuthUser = this.localStorageService.getCurrentUser();
    if(authUser != null){
      req = req.clone({headers: req.headers.set("Authorization", "Bearer " + authUser.token)});
    }

    // req = req.clone({
    //   headers:
    //     req.headers.set("Content-Type", "application/json") });
    console.log(req);
    return next.handle(req);
  }

}
