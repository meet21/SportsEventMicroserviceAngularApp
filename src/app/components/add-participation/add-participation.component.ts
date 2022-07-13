import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Participantslistpojo } from 'src/app/participantslistpojo';
import { ParticipationserviceService } from 'src/services/participationservice.service';

@Component({
  selector: 'app-add-participation',
  templateUrl: './add-participation.component.html',
  styleUrls: ['./add-participation.component.css']
})
export class AddParticipationComponent implements OnInit {

  addParticipanToList = new Participantslistpojo();
  constructor(private service:ParticipationserviceService,  private _route: Router) { }

  ngOnInit(): void {
  }

  addparticipant(){
    this.service.addParticipantToList(this.addParticipanToList).subscribe
    (
      data=>{
        console.log("Participant added succcessfully");
        this._route.navigate(['/participationList']);
      },
      error=>{
        console.log("Participant not added");
      }
    );
  }

}
