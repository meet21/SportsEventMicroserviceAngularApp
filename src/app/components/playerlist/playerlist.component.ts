import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PlayerserviceService } from 'src/services/playerservice.service';

@Component({
  selector: 'app-playerlist',
  templateUrl: './playerlist.component.html',
  styleUrls: ['./playerlist.component.css']
})
export class PlayerlistComponent implements OnInit {

  playerarray:any;
  noDataDisplay='';
  constructor(private service:PlayerserviceService,private _route: Router) { }

  ngOnInit(): void {
    this.service.playerlist().subscribe(
      (resp) =>{
        console.log(resp);
        this.playerarray = resp;
        if(this.playerarray=='' || this.playerarray==null){
          this.noDataDisplay = "No Data Found, Please add player from Participants List";
        }
      },
      error =>{
        console.log("error fetching playerlist")
        this.noDataDisplay = "No Data Found, Please add player from Participants List";
      }
      
    );
  }

  deletePlayer(player: { playerId: number; },playerId: any){
    this.service.deletePlayer(player.playerId).subscribe(
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
