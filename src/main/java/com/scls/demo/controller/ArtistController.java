package com.scls.demo.controller;

import com.scls.demo.model.Artist;
import com.scls.demo.model.Song;
import com.scls.demo.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ArtistController {
    private ArtistService artistService;

    @Autowired
    public void setArtistService(ArtistService artistService){
        this.artistService = artistService;
    }

    //http://localhost:9092/artists
    @GetMapping(path = "/artists")
    public List<Artist> getArtists(){
        System.out.println("Calling getArtists()");
        return artistService.getArtists();
    }

    //http://localhost:9092/artists/{artistId}
    @GetMapping(path = "/artists/{artistId}")
    public Artist getArtist(@PathVariable Long artistId){
        System.out.println("Calling getArtist()");
        return artistService.getArtist(artistId);
    }

    //http://localhost:9092/artists/{artistId}/songs
    @GetMapping(path = "/artists/{artistId}/songs")
    public List<Song> getArtistSongs(@PathVariable Long artistId){
        System.out.println("Calling getArtistSongs()");
        return artistService.getArtistSongs(artistId);
    }

    //http://localhost:9092/artists/{artistId}/songs/{songId}
    @GetMapping(path = "/artists/{artistId}/songs/{songId}")
    public Song getArtistSong(@PathVariable Long artistId, @PathVariable Long songId){
        System.out.println("Calling getArtistSong()");
        return artistService.getArtistSong(artistId, songId);
    }

    //http://localhost:9092/artists
    @PostMapping(path = "/artists")
    public Artist createArtist(@RequestBody Artist artistObject){
        System.out.println("Calling createArtist()");
        return artistService.createArtist(artistObject);
    }

    //http://localhost:9092/labels/{labelId}/artists
    @PostMapping(path = "/labels/{labelId}/artists")
    public Artist createLabelArtist(@PathVariable Long labelId, @RequestBody Artist artistObject){
        System.out.println("Calling createLabelArtist()");
        return artistService.createLabelArtist(labelId, artistObject);
    }

    //http://localhost:9092/artists/{artistId}
    @PutMapping(path = "/artists/{artistId}")
    public Artist updateArtist(@PathVariable Long artistId, @RequestBody Artist artistObject){
        System.out.println("Calling updateArtist()");
        return artistService.updateArtist(artistId, artistObject);
    }

    //http://localhost:9092/artists/{artistId}
    @DeleteMapping(path = "/artists/{artistId}")
    public ResponseEntity<HashMap> deleteArtist(@PathVariable Long artistId){
        System.out.println("Calling deleteArtist()");
        artistService.deleteArtist(artistId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "artist with id: " + artistId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }

}
