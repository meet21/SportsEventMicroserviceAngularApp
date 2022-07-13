import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ParticipationserviceService } from 'src/services/participationservice.service';

@Component({
  selector: 'app-participation-status',
  templateUrl: './participation-status.component.html',
  styleUrls: ['./participation-status.component.css']
})
export class ParticipationStatusComponent implements OnInit {

  participationarray:any;
  participationdeclined:any;
  participationPending:any;

  noDataDisplay='';
  noDataDisplay1='';
  noDataDisplay2='';

  statusApproved="Approved";
  statusDeclined="Declined";
  statusPending="pending";
  constructor(private service:ParticipationserviceService,private _route: Router) { }

  ngOnInit(): void {
    this.service.participationStatus(this.statusApproved).subscribe(
      (resp) =>{
        console.log(resp);
        this.participationarray = resp;
        if(this.participationarray=='' || this.participationarray==null){
          this.noDataDisplay = "No Data Found, Please Approve the Participants";
        }
      },
      error =>{
        console.log("error fetching playerlist")
        this.noDataDisplay = "No Data Found, Please Approve the Participants";
      }
      
    );

    this.service.participationStatus(this.statusDeclined).subscribe(
      (resp) =>{
        console.log(resp);
        this.participationdeclined = resp;
        if(this.participationdeclined=='' || this.participationdeclined==null){
          this.noDataDisplay1 = "No declined participants";
        }
      },
      error =>{
        console.log("error fetching playerlist")
        this.noDataDisplay1 = "No declined participants";
      }
      
    );

    this.service.participationStatus(this.statusPending).subscribe(
      (resp) =>{
        console.log(resp);
        this.participationPending = resp;
        if(this.participationPending=='' || this.participationPending==null){
          this.noDataDisplay2 = "No Pending participants";
        }
      },
      error =>{
        console.log("error fetching playerlist")
        this.noDataDisplay2 = "No Pending participants";
      }
      
    );
    
  }

  

}
