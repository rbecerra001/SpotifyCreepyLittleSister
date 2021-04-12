package com.scls.demo.controller;

import com.scls.demo.model.Song;
import com.scls.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    private SongService songService;

    @Autowired
    public void setSongService(SongService songService){
        this.songService = songService;
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
        return songService.getSongs();
    }

    //http://localhost:9092/songs/{songId}
    @GetMapping(path = "/songs/{songId}")
    public Song getSong(@PathVariable Long songId){
        System.out.println("Calling getSong ==>");
        return songService.getSong(songId);
    }

//    get all songs
//    get single song
//    create single song with artist and genre
//    update single song
//    delete single song
}
