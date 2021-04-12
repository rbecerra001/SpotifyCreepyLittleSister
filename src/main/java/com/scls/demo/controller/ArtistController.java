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
}