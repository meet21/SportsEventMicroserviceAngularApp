import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Participantslistpojo } from 'src/app/participantslistpojo';

@Injectable({
  providedIn: 'root'
})
export class ParticipationserviceService {

  constructor(private http:HttpClient) { }

  participationlist(){
    return this.http.get("http://localhost:7000/participations");
  }

  public addParticipantToList(addplayerlist: Participantslistpojo){
    return this.http.post<any>("http://localhost:7000/participations",addplayerlist);
  }

  public approval(id:number,approved:any){
    return this.http.put("http://localhost:7000/participations/"+id,approved);

  }

  public participationStatus(status:any){
    return this.http.get("http://localhost:7000/participations/"+status);
  }

}
