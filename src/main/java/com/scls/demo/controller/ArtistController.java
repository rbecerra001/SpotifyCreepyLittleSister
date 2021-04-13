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

/*
* A Rest Controller for the Artist model.
*/
@RestController
public class ArtistController {
    private ArtistService artistService; // handles the business end of Artist Model (separation of concerns)

    @Autowired // dependency injection
    public void setArtistService(ArtistService artistService){
        this.artistService = artistService;
    }

    /*
     * http://localhost:9092/artists
     *
     * Gets all artists in artist model.
     * params: none
     * returns: List<Artist> - a list of Artists in the model
     */
    @GetMapping(path = "/artists")
    public List<Artist> getArtists(){
        System.out.println("Calling getArtists()");
        return artistService.getArtists();
    }

    /*
     * http://localhost:9092/artists/{artistId}
     *
     * Get a single artist in artist model.
     * params: Long artistId - id of artist
     * returns: Artist - an Artist in the model
     */
    @GetMapping(path = "/artists/{artistId}")
    public Artist getArtist(@PathVariable Long artistId){ // return
        System.out.println("Calling getArtist()");
        return artistService.getArtist(artistId);
    }

    /*
     * http://localhost:9092/artists/{artistId}/songs
     *
     * Gets all the songs from a single artist.
     * params: Long artistId - id of artist
     * returns: List<Song> - a list of songs written by the given artist
     */
    @GetMapping(path = "/artists/{artistId}/songs")
    public List<Song> getArtistSongs(@PathVariable Long artistId){
        System.out.println("Calling getArtistSongs()");
        return artistService.getArtistSongs(artistId);
    }

    /*
     * http://localhost:9092/artists/{artistId}/songs/{songId}
     *
     * Get a single song from a single artist.
     * params: Long artistId - id of artist
     *         Long songId - id of song
     * returns: Song - a single song written by the given artist
     */
    @GetMapping(path = "/artists/{artistId}/songs/{songId}")
    public Song getArtistSong(@PathVariable Long artistId, @PathVariable Long songId){
        System.out.println("Calling getArtistSong()");
        return artistService.getArtistSong(artistId, songId);
    }

    /*
     * http://localhost:9092/artists
     *
     * Creates a single artist with out a Label
     * params: Artist artistObject - information needed to create an artist (name(required), description, monthly_streamers)
     * returns: Artist - the created Artist entry
     */
    @PostMapping(path = "/artists")
    public Artist createArtist(@RequestBody Artist artistObject){
        System.out.println("Calling createArtist()");
        return artistService.createArtist(artistObject);
    }

    /*
     * http://localhost:9092/labels/{labelId}/artists
     *
     * Creates a single artist with a Label
     * params: Artist artistObject - information needed to create an artist (name(required), description, monthly_streamers)
     *         Long labelId - the id of the label that owns the artist
     * returns: Artist - the created Artist entry
     */
    @PostMapping(path = "/labels/{labelId}/artists")
    public Artist createLabelArtist(@PathVariable Long labelId, @RequestBody Artist artistObject){
        System.out.println("Calling createLabelArtist()");
        return artistService.createLabelArtist(labelId, artistObject);
    }

    /*
     * http://localhost:9092/artists/{artistId}
     *
     * Updates a single artist
     * params: Artist artistObject - information needed to updated an artist (name(required), description, monthly_streamers)
     *         Long artistId - the id of the artist to be updated
     * returns: Artist - the updated Artist entry
     */
    @PutMapping(path = "/artists/{artistId}")
    public Artist updateArtist(@PathVariable Long artistId, @RequestBody Artist artistObject){
        System.out.println("Calling updateArtist()");
        return artistService.updateArtist(artistId, artistObject);
    }

    /*
     * http://localhost:9092/artists/{artistId}
     *
     * Deletes a single artist and all the labels connected to it
     * params: Long artistId - the id of the artist to be deleted
     * returns: ResponseEntity<HashMap> - a message letting the user know the artist was successfully deleted
     */
    @DeleteMapping(path = "/artists/{artistId}")
    public ResponseEntity<HashMap> deleteArtist(@PathVariable Long artistId){
        System.out.println("Calling deleteArtist()");
        artistService.deleteArtist(artistId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "artist with id: " + artistId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }

}
