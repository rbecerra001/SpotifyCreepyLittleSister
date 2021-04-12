package com.scls.demo.service;

import com.scls.demo.model.Artist;
import com.scls.demo.model.Song;
import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.LabelRepository;
import com.scls.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private GenreRepository genreRepository;

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

    public List<Song> getSongs(){
        System.out.println("Service calling getSongs ==>");
        List<Song> songs = songRepository.findByUserId
        if(songs.isEmpty()){
            throw new Informationnotfoundexception("no categories found for that user id" + userDetails.getUser().getId());
        } else{
            return categories;
        }
    }

}
