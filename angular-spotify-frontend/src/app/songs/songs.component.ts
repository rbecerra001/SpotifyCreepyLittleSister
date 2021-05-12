import { SongsService } from 'src/app/services/songs/songs.service';
import { Component, OnInit } from '@angular/core';
declare const M;

@Component({
  selector: 'app-songs',
  templateUrl: './songs.component.html',
  styleUrls: ['./songs.component.css']
})
export class SongsComponent implements OnInit {
  public songs: any[];

  constructor(private songsService: SongsService) { }

  getSongs(): any {
    this.songsService.getSongs().subscribe(response => {
      this.songs = response;
    }, err => console.log(err));
  }

  ngOnInit(): void {
    this.getSongs();

    if (!localStorage.getItem('currentUser')) {
      const toastHTML = '<span>You must login to see your songs</span>';
      M.toast({html: toastHTML});
    }
  }

}
