import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Playerlistpojo } from 'src/app/playerlistpojo';
import { PlayerserviceService } from 'src/services/playerservice.service';

@Component({
  selector: 'app-addplayer',
  templateUrl: './addplayer.component.html',
  styleUrls: ['./addplayer.component.css']
})
export class AddplayerComponent implements OnInit {
  addplayerlist = new Playerlistpojo();

  constructor(private service:PlayerserviceService,  private _route: Router) { }

  ngOnInit(): void {
  }

  addplayer(){
    this.service.addPlayerToList(this.addplayerlist).subscribe
    (
      data=>{
        console.log("player added succcessfully");
        this._route.navigate(['/playerlist']);
      },
      error=>{
        console.log("player not added");
      }
    )
  }

}
