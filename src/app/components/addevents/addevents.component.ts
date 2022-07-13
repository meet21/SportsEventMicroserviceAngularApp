import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Eventlistpojo } from 'src/app/eventlistpojo';
import { EventserviceService } from 'src/services/eventservice.service';

@Component({
  selector: 'app-addevents',
  templateUrl: './addevents.component.html',
  styleUrls: ['./addevents.component.css']
})
export class AddeventsComponent implements OnInit {
  addEventList = new Eventlistpojo();
  constructor(private service:EventserviceService,  private _route: Router) { }

  ngOnInit(): void {
  }

  addEvent(){
    this.service.addEventToList(this.addEventList).subscribe
    (
      data=>{
        console.log("Event added succcessfully");
        this._route.navigate(['/event']);
      },
      error=>{
        console.log("Event not added");
      }
    )
  }

}
