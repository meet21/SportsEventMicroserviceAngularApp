import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Playerlistpojo } from 'src/app/playerlistpojo';

@Injectable({
  providedIn: 'root'
})
export class PlayerserviceService {

  constructor(private http:HttpClient) { }
  playerlist(){
    return this.http.get("http://localhost:8081/players");
  }

  public addPlayerToList(addplayerlist: Playerlistpojo){
    return this.http.post<any>("http://localhost:8090/addplayer",addplayerlist);
  }

  public deletePlayer(id:number){
    return this.http.delete<any>("http://localhost:8081/players/"+id);
  }
}
