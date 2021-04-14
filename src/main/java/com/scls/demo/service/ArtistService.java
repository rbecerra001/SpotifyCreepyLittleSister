package com.scls.demo.service;

import com.scls.demo.exception.InformationExistException;
import com.scls.demo.exception.InformationNotFoundException;
import com.scls.demo.model.Artist;
import com.scls.demo.model.Label;
import com.scls.demo.model.Song;
import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.LabelRepository;
import com.scls.demo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * ArtistService implements the business logic for ArtistController.
 */
@Service
public class ArtistService {
    private ArtistRepository artistRepository;
    private LabelRepository labelRepository;


    @Autowired // dependency injection
    public void setArtistRepository(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    @Autowired // dependency injection
    public void setLabelRepository(LabelRepository labelRepository){
        this.labelRepository = labelRepository;
    }

    /*
     * Gets all artists in artist model.
     * params: none
     * returns: List<Artist> - a list of Artists in the model. If there are no artists, the list will be empty.
     */
    public List<Artist> getArtists(){
        System.out.println("Calling getArtists() in service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return artistRepository.findByUserId(userDetails.getUser().getId());
    }

    /*
     * Get a single artist in artist model.
     * params: Long artistId - id of artist
     * returns: Artist - an Artist in the model. If the artist isn't present, an exception is thrown.
     */
    public Artist getArtist(Long artistId){
        System.out.println("Calling getArtist() in service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Optional<Artist> artist = artistRepository.findByIdAndUserId(artistId,userDetails.getUser().getId());
        if(artist.isPresent()){
            return artist.get();
        }else{
            throw new InformationNotFoundException("The artist at id " + artistId + " does not exist ");
        }
    }

    /*
     * Gets all the songs from a single artist.
     * params: Long artistId - id of artist
     * returns: List<Song> - a list of songs written by the given artist
     */
    public List<Song> getArtistSongs(Long artistId){
        System.out.println("Calling getArtistSongs() in service");
        Artist artist = getArtist(artistId);
        return artist.getSongList();
    }

    /*
     * Get a single song from a single artist.
     * params: Long artistId - id of artist
     *         Long songId - id of song
     * returns: Song - a single song written by the given artist. If the song isn't present, an exception is thrown.
     */
    public Song getArtistSong(Long artistId, Long songId){
        System.out.println("Calling getArtistSong() in service");
        Optional<Song> song = getArtistSongs(artistId).stream().filter(s -> s.getId().equals(songId)).findFirst();
        if (song.isPresent()){
            return song.get();
        }else{
            throw new InformationNotFoundException("The song with id " + songId + " does not exist with the given artist id" + artistId);
        }
    }

    /*
     * Creates a single artist with out a Label
     * params: Artist artistObject - information needed to create an artist (name(required), description, monthly_streamers)
     * returns: Artist - the created Artist entry
     */
    public Artist createArtist(Artist artistObject){
        System.out.println("Calling createArtist() in service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        artistObject.setUser(userDetails.getUser());
        return artistRepository.save(artistObject);
    }

    /*
     * Creates a single artist with a Label
     * params: Artist artistObject - information needed to create an artist (name(required), description, monthly_streamers)
     *         Long labelId - the id of the label that owns the artist
     * returns: Artist - the created Artist entry. If the label isn't present, an exception is thrown.
     */
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

    /*
     * Updates a single artist
     * params: Artist artistObject - information needed to updated an artist (name(required), description, monthly_streamers)
     *         Long artistId - the id of the artist to be updated
     * returns: Artist - the updated Artist entry
     */
    public Artist updateArtist(Long artistId, Artist artistObject){
        System.out.println("Calling updateArtist() in service");
        Artist artist = getArtist(artistId);
        artist.setName(artistObject.getName());
        artist.setDescription(artistObject.getDescription());
        artist.setMonthlyStreamers(artistObject.getMonthlyStreamers());
        return artistRepository.save(artist);
    }

    /*
     * Deletes a single artist
     * params: Long artistId - the id of the artist to be deleted
     * returns: none
     */
    public void deleteArtist(Long artistId){
        System.out.println("Calling deleteArtist() in service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(artistRepository.findByIdAndUserId(artistId, userDetails.getUser().getId()).isPresent()){
            artistRepository.deleteById(artistId);
        }else{
            throw new InformationNotFoundException("Artist with id " + artistId + " does not exist");
        }
    }
}
