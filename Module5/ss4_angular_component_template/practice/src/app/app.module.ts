import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AngularHackernewsAppComponent } from './angular-hackernews-app/angular-hackernews-app.component';
import {FormsModule} from "@angular/forms";
import { LikeComponent } from './like/like.component';

@NgModule({
  declarations: [
    AppComponent,
    AngularHackernewsAppComponent,
    LikeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
