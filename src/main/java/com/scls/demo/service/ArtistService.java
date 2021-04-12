package com.scls.demo.service;

import com.scls.demo.exception.InformationExistException;
import com.scls.demo.exception.InformationNotFoundException;
import com.scls.demo.model.Artist;
import com.scls.demo.model.Label;
import com.scls.demo.model.Song;
import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.LabelRepository;
import com.scls.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
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

    public List<Artist> getArtists(){
        System.out.println("Calling getArtists() in service");
        return artistRepository.findAll();
    }
    public Artist getArtist(Long artistId){
        System.out.println("Calling getArtist() in service");
        Optional<Artist> artist = artistRepository.findById(artistId);
        if(artist.isPresent()){
            return artist.get();
        }else{
            throw new InformationNotFoundException("The artist at id " + artistId + " does not exist ");
        }
    }

    public List<Song> getArtistSongs(Long artistId){
        System.out.println("Calling getArtistSongs() in service");
        Artist artist = getArtist(artistId);
        return artist.getSongList();
    }

    public Song getArtistSong(Long artistId, Long songId){
        System.out.println("Calling getArtistSong() in service");
        Optional<Song> song = getArtistSongs(artistId).stream().filter(s -> s.getId() == songId).findFirst();
        if (song.isPresent()){
            return song.get();
        }else{
            throw new InformationNotFoundException("The song with id " + songId + " does not exist with the given artist id" + artistId);
        }
    }

    public Artist createArtist(Artist artistObject){
        System.out.println("Calling createArtist() in service");
        Artist artist = artistRepository.findByName(artistObject.getName());
        if (artist == null){
            return artistRepository.save(artistObject);
        }else{
            throw new InformationExistException("Artist with name " + artist.getName() + " already  exists");
        }
    }

    public Artist createLabelArtist(Long labelId, Artist artistObject){
        System.out.println("Calling createLabelArtist() in service");
        Optional<Label> label = labelRepository.findById(labelId);
        if (label.isPresent()){
            Artist artist = createArtist(artistObject);
            artist.setLabel(label.get());
            return artistRepository.save(artist);
        }else{
            throw new InformationNotFoundException("Label with id " + labelId + " does not exist");
        }
    }

    public Artist updateArtist(Long artistId, Artist artistObject){
        System.out.println("Calling updateArtist() in service");
        Artist artist = getArtist(artistId);
        if (artistRepository.findByName(artistObject.getName()) != null){
            throw new InformationExistException("Artist with name " + artistObject.getName() + " already exists");
        }else{
            artist.setName(artistObject.getName());
            artist.setDescription(artistObject.getDescription());
            artist.setMonthly_streamers(artistObject.getMonthly_streamers());
            return artistRepository.save(artist);
        }
    }

    public void deleteArtist(Long artistId){
        System.out.println("Calling deleteArtist() in service");
        if(artistRepository.findById(artistId).isPresent()){
            artistRepository.deleteById(artistId);
        }else{
            throw new InformationNotFoundException("Artist with id " + artistId + " does not exist");
        }
    }
}
