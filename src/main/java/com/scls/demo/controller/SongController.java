package com.scls.demo.controller;

import com.scls.demo.model.Song;
import com.scls.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    private SongService songService;

    @Autowired
    public void setSongService(SongService songService){
        this.songService = songService;
    }

    //http://localhost:{PORTNUMBER}/helloworld
    @GetMapping(path = "/helloworld")
    public String helloWorld(){
        return "Hello World";
    }
    // This will test to make sure the database is running and ports are properly set up

    //http://localhost:{PORTNUMBER}/songs
    @GetMapping(path = "/songs")
    public List<Song> getSongs(){
        System.out.println("Calling getSongs ==>");
        return songService.getSongs();
    }
    // this endpoint will call the service class to get all songs in the model

    //http://localhost:{PORTNUMBER}/songs/{songId}
    @GetMapping(path = "/songs/{songId}")
    public Song getSong(@PathVariable Long songId){
        System.out.println("Calling getSong ==>");
        return songService.getSong(songId);
    }
    // this endpoint will call the service class to get a single song using the song ID

    // http://localhost:{PORTNUMBER}/artists/{artistId}/genres/{genreId}/songs
    @PostMapping(path="/artists/{artistId}/genres/{genreId}/songs")
    public Song createSong(@PathVariable Long artistId, @PathVariable Long genreId, @RequestBody Song songObject){
        System.out.println("Calling createSong ==>");
        return songService.createSong(artistId, genreId, songObject);
    }
    // tthis endpoint will call the service class to create a song that requires an artist to exist as well as a genre
    // in order to use the artist ID and genre ID

    // http://localhost:{PORTNUMBER}/songs/{songId}
    @PutMapping(path="/songs/{songId}")
    public Song updateSong(@PathVariable Long songId, @RequestBody Song songObject){
        System.out.println("Calling updateSong ==>");
        return songService.updateSong(songId, songObject);
    }
    // this endpoint will call the service class to update a song using the song ID

    // http://localhost:{PORTNUMBER}/songs/{songId}
    @DeleteMapping(path="/songs/{songId}")
    public Song deleteSong(@PathVariable Long songId){
        System.out.println("Calling deleteSong ==>");
        return songService.deleteSong(songId);
    }
    // this endpoint will call the service class to delete a song using the song ID
}
