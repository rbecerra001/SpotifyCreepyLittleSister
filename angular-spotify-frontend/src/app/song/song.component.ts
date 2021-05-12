import { SongsService } from 'src/app/services/songs/songs.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

// @ts-ignore
@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css']
})
export class SongComponent implements OnInit {
  songId: string;
  song: any;
  recipeName = '';

  constructor(private route: ActivatedRoute, private songsService: SongsService) { }

  ngOnInit(): void {
    this.route.paramMap
      .subscribe( params => {
        this.songId = params.get('id');
        this.songsService.getSong(this.songId).subscribe(response => {
          this.song = response;
          console.log(this.song);
        });
      });
  }
}
