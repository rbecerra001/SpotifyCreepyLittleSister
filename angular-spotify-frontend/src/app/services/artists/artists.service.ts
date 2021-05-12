import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

const herokuUrl = 'http://localhost:9092';

@Injectable({
  providedIn: 'root'
})

export class ArtistsService {

  constructor(private http: HttpClient) { }

  getArtists(): any {
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .get(`${herokuUrl}/artists`, requestOptions);
  }

  createArtist(newArtist): any {
    console.log(newArtist);
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .post(`${herokuUrl}/artists/`, newArtist, requestOptions);
  }

  getArtist(artistId): any {
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .get(`${herokuUrl}/artists/${artistId}`, requestOptions);
  }

  deleteArtist(artist): any {
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders({
        Authorization: `Bearer ${token}`
      }),
    };
    return this.http
      .delete(`${herokuUrl}/artists/${artist.id}`, requestOptions);
  }
}
