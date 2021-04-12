package com.scls.demo.controller;

import com.scls.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {
    private GenreService genreService;

    @Autowired
    public void setGenreService(GenreService genreService){
        this.genreService = genreService;
    }
}
