import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

const herokuUrl = 'http://localhost:9092';

@Injectable({
  providedIn: 'root'
})
export class ArtistsService {

  constructor(private http: HttpClient) { }

  getGenres(): any {
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .get(`${herokuUrl}/genres`, requestOptions);
  }

  createGenre(newGenre): any {
    console.log(newGenre);
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .post(`${herokuUrl}/genres/`, newGenre, requestOptions);
  }

  getGenre(genreId): any {
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .get(`${herokuUrl}/genres/${genreId}`, requestOptions);
  }

  createSong(genre, newSong): any {
    console.log('service: ', genre, newSong);
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .post(`${herokuUrl}/genres/${genre.id}/songs`, newSong, requestOptions);
  }

  deleteGenre(genre): any {
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .delete(`${herokuUrl}/genres/${genre.id}`, requestOptions);
  }

  deleteSong(genre, songId): any {
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .delete(`${herokuUrl}/genres/${genre.id}/songs/${songId}`, requestOptions);
  }
}
