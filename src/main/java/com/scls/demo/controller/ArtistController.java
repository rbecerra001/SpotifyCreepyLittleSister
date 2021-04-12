package com.scls.demo.controller;

import com.scls.demo.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {
    private ArtistService artistService;

    @Autowired
    public void setArtistService(ArtistService artistService){
        this.artistService = artistService;
    }

//    GET	/artists	None	get all artists
//    GET	/artists/{artistId}	None	get a single artist
//    GET	/artists/{artistId}/songs	None	gets all songs by an artist
//    GET	/artists/{artistId}/songs/{songId}	None	gets a single song by an artist**
//    POST	/artists	artist info	creates a single artist
//    POST	/labels/{labelId}/artists	artist info	creates a single artist with a label**
//    PUT	/artists/{artistId}	artist info	updates a single artist
//    DELETE	/artists/{artistId}	None	deletes a single artist
}
