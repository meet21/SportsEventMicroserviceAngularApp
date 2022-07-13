import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ParticipationserviceService } from 'src/services/participationservice.service';

@Component({
  selector: 'app-participation-list',
  templateUrl: './participation-list.component.html',
  styleUrls: ['./participation-list.component.css']
})
export class ParticipationListComponent implements OnInit {

  participationarray:any;
  noDataDisplay='';
  status='';
  constructor(private service:ParticipationserviceService,private _route: Router) { }

  ngOnInit(): void {
    this.service.participationlist().subscribe(
      (resp) =>{
        console.log(resp);
        this.participationarray = resp;
        this.status = this.participationarray.status;
        console.log(this.participationarray);
        if(this.participationarray=='' || this.participationarray==null){
          this.noDataDisplay = "No Data Found, Please add player";
        }
      },
      error =>{
        console.log("error fetching playerlist")
        this.noDataDisplay = "No Data Found, Please add player";
      }
      
    );
  }
  approval(player: { participationId: number; },participationId: any){
    const approve={
      "participationId":participationId,
      "status":"Approved"
    }
    this.service.approval(player.participationId,approve).subscribe(
      (resp) =>{
        console.log(resp);
        this.ngOnInit();
      },
      error =>{
        console.log("Not Approved")
      }
      
    );

  }

  decline(player: { participationId: number; },participationId: any){
    const decline={
      "participationId":participationId,
      "status":"Declined"
    }
    this.service.approval(player.participationId,decline).subscribe(
      (resp) =>{
        console.log(resp);
        this.ngOnInit();
      },
      error =>{
        console.log("Not Approved")
      }
      
    );

  }

  // deleteparticipation(player: { playerId: number; },playerId: any){
  //   this.service.deleteparticipation(player.playerId).subscribe(
  //     (resp)=>{
  //       console.log(resp);
  //       this.ngOnInit();
  //     },
  //     error=>{
  //       console.log(error);
  //       this.ngOnInit();
  //     }     
  //   );
  // }

}
