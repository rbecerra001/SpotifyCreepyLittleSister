package com.scls.demo.service;

import com.scls.demo.model.Artist;
import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.LabelRepository;
import com.scls.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//        GET	/artists/{artistId}	None	get a single artist
//        GET	/artists/{artistId}/songs	None	gets all songs by an artist
//        GET	/artists/{artistId}/songs/{songId}	None	gets a single song by an artist**
//        POST	/artists	artist info	creates a single artist
//        POST	/labels/{labelId}/artists	artist info	creates a single artist with a label**
//        PUT	/artists/{artistId}	artist info	updates a single artist
//        DELETE	/artists/{artistId}	None	deletes a single artist
@Service
public class ArtistService {

    private SongRepository songRepository;
    private ArtistRepository artistRepository;
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
    public void setLabelRepository(LabelRepository labelRepository){
        this.labelRepository = labelRepository;
    }

    public List<Artist> getArtists(){
        return artistRepository.findAll();
    }
    public Optional<Artist> getArtist(Long artistId){
        Optional<Artist> artist = artistRepository.findById(artistId);
        if
    }
}
