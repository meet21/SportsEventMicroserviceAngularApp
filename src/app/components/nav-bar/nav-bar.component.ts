import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from 'src/services/loginservice.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  userNameDisplay:string | null | undefined;
  public loggedIn=false;

  constructor(private loginService:LoginserviceService) { }

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
    this.userNameDisplay = localStorage.getItem("userName");

  }

  logoutUser(){
    console.log("logout pressed");
    this.loginService.logout()
    location.reload()
  }
}
