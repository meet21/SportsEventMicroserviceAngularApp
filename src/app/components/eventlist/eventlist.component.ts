import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventserviceService } from 'src/services/eventservice.service';

@Component({
  selector: 'app-eventlist',
  templateUrl: './eventlist.component.html',
  styleUrls: ['./eventlist.component.css']
})
export class EventlistComponent implements OnInit {

  Eventarray:any;
  constructor(private service:EventserviceService,private _route: Router) { }

  ngOnInit(): void {
    this.service.event().subscribe(
      (resp) =>{
        console.log(resp);
        this.Eventarray = resp;
      },
      error =>console.log("error fetching Eventlist")
    );
  }

  deleteEvent(Event: { eventId: number; },eventId:number){
    this.service.deleteEvent(Event.eventId).subscribe(
      (resp)=>{
        console.log(resp);
        this.ngOnInit();
      },
      error=>{
        console.log(error);
        this.ngOnInit();
      }     
    );
  }

}
