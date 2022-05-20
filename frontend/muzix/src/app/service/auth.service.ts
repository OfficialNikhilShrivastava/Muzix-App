import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  redirectUrl: string = "";
  constructor(private router: Router) { }
  _isLoggedIn: boolean = false;
  login() {
    this._isLoggedIn = true;
    return this._isLoggedIn;
  }
  logout() {
    this._isLoggedIn = false;
    this.router.navigate(['/auth/login']);
    return this._isLoggedIn;

  }



  // login_user(form: string) {
  //    this._isLoggedIn.next(true) ;
  //   //  this._isLoggedIn.next(false) ;
  // }

  // get isLoggedIn() {
  //   return this._isLoggedIn.asObservable();
  // }

  // auth.service.ts

  // private loggedIn = new BehaviorSubject<boolean>(localStorage.getItem("isLoggedIn") === "true");

  // login(user: any) {
  //   if (user.userName === "admin" && user.password === "admin") {
  //     localStorage.setItem("isLoggedIn", "true");
  //     localStorage.setItem("token", "add some unique token here");
  //     console.log(localStorage);
  //     this.loggedIn.next(true);
  //     console.log(this.loggedIn);
  //     this.router.navigate(["/dashboard/home"]);
  //   }
  // }
}
