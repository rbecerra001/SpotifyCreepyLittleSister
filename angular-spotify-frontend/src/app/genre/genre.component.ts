import { GenresService } from 'src/app/services/genres/genres.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-genre',
  templateUrl: './genre.component.html',
  styleUrls: ['./genre.component.css']
})
export class GenreComponent implements OnInit {
  genreId: string;
  genre: any;
  songName = '';

  constructor(private route: ActivatedRoute, private genresService: GenresService) { }

  createRecipe(): any {
    console.log('component: ', this.genre, this.songName);
    const newSong = {name: this.songName};
    this.genresService.createSong(this.genre, newSong).subscribe(response => {
      console.log(response);
    });
  }

  createSong(genre): any {
    console.log('component: ', genre, this.songName);
    const newSong = {name: this.songName};
    this.genresService.createSong(genre, newSong).subscribe(response => {
      console.log(response);
    });
  }

  ngOnInit(): void {
    this.route.paramMap
      .subscribe( params => {
        this.genreId = params.get('id');
        this.genresService.getGenre(this.genreId).subscribe(response => {
          this.genre = response;
          console.log(this.genre);
        });
      });
  }
}
