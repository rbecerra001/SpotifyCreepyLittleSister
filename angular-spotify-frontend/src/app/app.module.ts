import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from "./signup/signup.component";
import { LoginComponent } from './login/login.component';
import { GenresComponent } from './genres/genres.component';
import { LogoutComponent } from './logout/logout.component';
import { GenreComponent } from './genre/genre.component';
import { SongComponent } from './song/song.component';
import { SongsComponent } from './songs/songs.component';
import { ArtistComponent } from './artist/artist.component';
import { ArtistsComponent } from './artists/artists.component';
import { LabelComponent } from './label/label.component';
import { LabelsComponent } from './labels/labels.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignupComponent,
    LoginComponent,
    GenresComponent,
    LogoutComponent,
    GenreComponent,
    SongComponent,
    SongsComponent,
    ArtistComponent,
    ArtistsComponent,
    LabelComponent,
    LabelsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
