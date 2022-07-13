import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Eventlistpojo } from 'src/app/eventlistpojo';

@Injectable({
  providedIn: 'root'
})
export class EventserviceService {

  constructor(private http:HttpClient) { }

  event(){
    return this.http.get("http://localhost:8082/events");
  }

  public addEventToList(addEventList: Eventlistpojo){
    return this.http.post<any>("http://localhost:8082/events",addEventList);
  }

  public deleteEvent(id:number){
    return this.http.delete<any>("http://localhost:8082/events/"+id);
  }

  public searchByName(searchByName:string){
    return this.http.get("http://localhost:8082/events/"+searchByName);
  }

  public sportslist(){
    return this.http.get("http://localhost:8082/sports");
  }

  public searchSportsByName(sportsName:string){
    return this.http.get("http://localhost:8082/sports/"+sportsName);
  }
}
