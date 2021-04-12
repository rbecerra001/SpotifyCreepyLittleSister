package com.scls.demo.service;

import com.scls.demo.model.Artist;
import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.LabelRepository;
import com.scls.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private GenreRepository genreRepository;
    private LabelRepository labelRepository;

    @Autowired
    public void setSongRepository(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @Autowired
    public void setLabelRepository(LabelRepository labelRepository){
        this.labelRepository = labelRepository;
    }

}
