package com.scls.demo.service;

import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.LabelRepository;
import com.scls.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelService {

    private ArtistRepository artistRepository;
    private LabelRepository labelRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    @Autowired
    public void setLabelRepository(LabelRepository labelRepository){
        this.labelRepository = labelRepository;
    }
}
