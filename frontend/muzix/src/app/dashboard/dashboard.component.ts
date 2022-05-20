import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MainService } from '../service/main.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  email: any;
  user: any;
  userName: any;
  userProfileImg: any;
  genderMale:any;
  genderFemale:any;
  isLogIn: any = this.authS._isLoggedIn;
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private authS: AuthService, private breakpointObserver: BreakpointObserver, private router: Router, private mainService: MainService) {

   }
  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    this.email = this.mainService.email;
    console.log(this.email);
    // this.mainService.getUser(this.email).subscribe((res: any)=>{
    //   console.log(res);
    // });
    if (this.isLogIn == true) {
      console.log("user by email");
      this.getUserByEmail();
    }
  }
  searchingItems(text: string) {
    if (text.length == 0) {
      return;
    }
    console.log(text);
    this.router.navigate(['/dashboard/search-items', text])
  }
  getUserByEmail() {
    this.mainService.getUser().subscribe(res => {
      this.user = res;
      this.userName = this.user.userName;
      if(this.user.gender=="male"){
        this.genderMale=this.user.gender;
      }
      else{
        this.genderFemale=this.user.gender;
      }
      this.userProfileImg = this.user.profilePicture;
      console.log(this.user);
    });
    // console.log(this.mainService.getUser());
  }
  loggedOut() {
    this.authS.logout();
  }

}
