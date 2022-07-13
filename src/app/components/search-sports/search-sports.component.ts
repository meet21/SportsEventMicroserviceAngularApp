import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventserviceService } from 'src/services/eventservice.service';

@Component({
  selector: 'app-search-sports',
  templateUrl: './search-sports.component.html',
  styleUrls: ['./search-sports.component.css']
})
export class SearchSportsComponent implements OnInit {

  searchSport!: string;
  sportsFetchedData:any;
  noDataDisplay='';
  constructor(private service:EventserviceService,  private route: Router) { }

  ngOnInit(): void {
  }

  searchBySportsName(){
    this.service.searchSportsByName(this.searchSport).subscribe
    (
      data=>{
        this.sportsFetchedData = data;
        console.log(this.sportsFetchedData);
        // this.route.navigate(['/event']);
        if(this.sportsFetchedData=='' || this.sportsFetchedData==null){
          this.noDataDisplay = "No Match Found !"
        }
      },
      error=>{
        console.log("Unable to find any sports");
        this.noDataDisplay = "No Match Found !"
      }
    )
  }

}
