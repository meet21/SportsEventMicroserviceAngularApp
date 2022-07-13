import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventserviceService } from 'src/services/eventservice.service';

@Component({
  selector: 'app-search-events',
  templateUrl: './search-events.component.html',
  styleUrls: ['./search-events.component.css']
})
export class SearchEventsComponent implements OnInit {

  constructor(private service:EventserviceService,  private route: Router) { }
  searchValue!: string;
  noDataDisplay='';

  fetchedData:any;
  ngOnInit(): void {
  }

  searchByName(){
    this.service.searchByName(this.searchValue).subscribe
    (
      data=>{
        this.fetchedData = data;
        console.log(this.fetchedData);
        if(this.fetchedData=='' || this.fetchedData==null){
          this.noDataDisplay ="No Match found!!"
        }
        // this.route.navigate(['/event']);
      },
      error=>{
        console.log("Event not added");
        this.noDataDisplay ="No Match found!!"
      }
    )
  }
  

}
