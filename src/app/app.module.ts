import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MatButtonModule} from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CommonModule } from '@angular/common';  
import { LoginserviceService } from 'src/services/loginservice.service';
import { AuthGuard } from 'src/services/auth.guard';
import { AuthInterceptor } from 'src/services/auth.interceptor';
import { PlayerlistComponent } from './components/playerlist/playerlist.component';
import {MatTableModule} from '@angular/material/table';
import { AddplayerComponent } from './components/addplayer/addplayer.component';
import { EventlistComponent } from './components/eventlist/eventlist.component';
import { AddeventsComponent } from './components/addevents/addevents.component';
import { SearchEventsComponent } from './components/search-events/search-events.component';
import { SportslistComponent } from './components/sportslist/sportslist.component';
import { SearchSportsComponent } from './components/search-sports/search-sports.component';
import { ParticipationListComponent } from './components/participation-list/participation-list.component';
import { AddParticipationComponent } from './components/add-participation/add-participation.component';
import { ParticipationStatusComponent } from './components/participation-status/participation-status.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    DashboardComponent,
    LoginComponent,
    PlayerlistComponent,
    AddplayerComponent,
    EventlistComponent,
    AddeventsComponent,
    SearchEventsComponent,
    SportslistComponent,
    SearchSportsComponent,
    ParticipationListComponent,
    AddParticipationComponent,
    ParticipationStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
    MatTableModule
  ],
  providers: [LoginserviceService,AuthGuard,[{provide:HTTP_INTERCEPTORS, useClass:AuthInterceptor,multi:true}]],
  bootstrap: [AppComponent]
})
export class AppModule { }
