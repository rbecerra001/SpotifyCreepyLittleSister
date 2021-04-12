package com.scls.demo.controller;

import com.scls.demo.model.Genre;
import com.scls.demo.model.Song;
import com.scls.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {
    private GenreService GenreService;

    @Autowired
    public void setGenreService(GenreService genreService){
        this.GenreService = genreService;
    }

    //http://localhost:9092/genres
    @GetMapping(path="/genre")
    public List<Genre> getGenres(){
        System.out.println("calling getGenres ==>");
        return GenreService.getGenres();
    }

    //http://localhost:9092/genres/{genreId}
    @GetMapping(path="/genre/{genreId}")
    public Genre getGenre(@PathVariable Long genreId){
        System.out.println("calling getGenre ==>");
        return GenreService.getGenre(genreId);
    }
    //http://localhost:9092/genres/{genreId}/songs
    @GetMapping (path="/genre/{genreId}/songs")
    public List<Song> getSongsinGenre(@PathVariable Long genreId){
        System.out.println("calling getSongsinGenre ==>");
        return GenreService.getSongsinGenre(genreId);
    }

    //http://localhost:9092/genres/{genreId}/songs/{songId}
    @GetMapping (path="/genre/{genreId}/songs/{songId}")
    public Song getSonginGenre(@PathVariable Long genreId, @PathVariable Long songId){
        System.out.println("calling getSonginGenre ==>");
        return GenreService.getSonginGenre(genreId, songId);
    }

    //http://localhost:9092/genres
    @PostMapping(path="/genres")
    public Genre createGenre(@RequestBody Genre genreObject){
        System.out.println("Calling createGenre ==>");
        return GenreService.createGenre(genreObject);
    }

    //http://localhost:9092/genres/{genreId}
    @PutMapping(path="/genres/{genreId}")
    public Genre updateGenre(@PathVariable Long genreId, @RequestBody Genre genreObject){
        System.out.println("Calling updateGenre ==>");
        return GenreService.updateGenre(genreId, genreObject);
    }

    //http://localhost:9092/genres/{genreId}
    @DeleteMapping(path="/genres/{genreId}")
    public Optional<Genre> deleteGenre(@PathVariable Long genreId){
        System.out.println("Calling deleteGenre ==>");
        return GenreService.deleteGenre(genreId);
    }
}
