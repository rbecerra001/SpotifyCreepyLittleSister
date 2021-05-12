import { GenresService } from 'src/app/services/genres/genres.service';
import { Component, OnInit } from "@angular/core";
declare const M;

@Component({
  selector: 'app-genres',
  templateUrl: './genres.component.html',
  styleUrls: ['./genres.component.css']
})
export class GenresComponent implements OnInit {
  public genres: any[];
  public genreName: string;
  public genreDescription: string;

  constructor(private genresService: GenresService) { }

  getGenres(): any {
    this.genresService.getGenres().subscribe(response => {
      this.genres = response;
    }, err => console.log(err));
  }

  createGenre(): any {
    const newGenre = {
      name: this.genreName,
      description: this.genreDescription
    };
    this.genresService.createGenre(newGenre).subscribe(response => {
      this.genres = [...this.genres, response];
    }, err => console.log(err));
  }

  ngOnInit(): void {
    this.getGenres();
    if (!localStorage.getItem('currentUser')) {
      const toastHTML = '<span>You must login to see your genres</span>';
      M.toast({html: toastHTML});
    }
  }
}
