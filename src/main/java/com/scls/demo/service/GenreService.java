package com.scls.demo.service;

import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.LabelRepository;
import com.scls.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    private SongRepository songRepository;
    private GenreRepository genreRepository;

    @Autowired
    public void setSongRepository(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }
}
