import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private http:HttpClient) { }

  generateToken(userName:string,password:string){
    return this.http.post("http://localhost:8091/authenticate",{userName,password},{responseType: 'text'});
  }

  //for login user
  // storing token in localstorage

  loginUser(token:any){
    sessionStorage.setItem("token",token)
    return true;
  }

  // to check user is logged in or not
  isLoggedIn(){
    let token = localStorage.getItem("token");
    if(token==undefined || token==='' || token==null){
      return false;
    }
    else{
      return true;
    }
  }

  // for log out
  logout(){
    localStorage.removeItem("token")
    return true;
  }

  // to get the token
  getToken(){
    return localStorage.getItem("token");
  }

}

