package com.scls.demo.controller;

import com.scls.demo.model.Song;
import com.scls.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    private SongService SongService;

    @Autowired
    public void setSongService(SongService songService){
        this.SongService = songService;
    }

    //http://localhost:9092/helloworld
    @GetMapping(path = "/helloworld")
    public String helloWorld(){
        return "Hello World";
    }

    //http://localhost:9092/songs
    @GetMapping(path = "/songs")
    public List<Song> getSongs(){
        System.out.println("Calling getSongs ==>");
        return SongService.getSongs();
    }

    //http://localhost:9092/songs/{songId}
    @GetMapping(path = "/songs/{songId}")
    public Song getSong(@PathVariable Long songId){
        System.out.println("Calling getSong ==>");
        return SongService.getSong(songId);
    }

    //http://localhost:9092/artists/{artistId}/genres/{genreId}/songs
    @PostMapping(path="/artists/{artistId}/genres/{genreId}/songs")
    public Song createSong(@PathVariable Long artistId, @PathVariable Long genreId, @RequestBody Song songObject){
        System.out.println("Calling createSong ==>");
        return SongService.createSong(artistId, genreId, songObject);
    }

    //http://localhost:9092/songs/{songId}
    @PutMapping(path="/songs/{songId}")
    public Song updateSong(@PathVariable Long songId, @RequestBody Song songObject){
        System.out.println("Calling updateSong ==>");
        return SongService.updateSong(songId, songObject);
    }

    //http://localhost:9092/songs/{songId}
    @DeleteMapping(path="/songs/{songId}")
    public Optional<Song> deleteSong(@PathVariable Long songId){
        System.out.println("Calling deleteSong ==>");
        return SongService.deleteSong(songId);
    }
}
