package com.scls.demo.service;

import com.scls.demo.exception.InformationExistException;
import com.scls.demo.exception.InformationNotFoundException;
import com.scls.demo.model.Artist;
import com.scls.demo.model.Genre;
import com.scls.demo.model.Song;
import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.SongRepository;
import com.scls.demo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Song> song = songRepository.findByUserId(userDetails.getUser().getId());
        if (song.isEmpty()) {
            throw new InformationNotFoundException("no songs found for user id " + userDetails.getUser().getId());
        } else {
            return song;
        }
    }

    public Song getSong(Long songId){
        System.out.println("Service calling getSong ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Song song = songRepository.findByIdAndUserId(songId, userDetails.getUser().getId());
        if (song != null){
            return song;
        }else{
            throw new InformationNotFoundException("Song with id " + songId + " cannot be found for this user");
        }
    }

    public Song createSong(Long artistId, Long genreId, Song songObject){
        System.out.println("Service calling createSong ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Artist artist = artistRepository.findByIdAndUserId(artistId, userDetails.getUser().getId());
        if (artist == null) {
            throw new InformationNotFoundException("artist with id " + artistId + " not found");
        }
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if (genre == null) {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
        Song song = songRepository.findByNameAndUserId(songObject.getName(), userDetails.getUser().getId());
        if (song != null){
            throw new InformationExistException("song with name " + songObject.getName() + " already exists from this user");
        }
        songObject.setArtist(artist);
        songObject.setGenre(genre);
        songObject.setUser(userDetails.getUser());
        return songRepository.save(songObject);
    }

    public Song updateSong(Long songId, Song songObject){
        System.out.println("Service calling updateSong ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Song song = songRepository.findByIdAndUserId(songId, userDetails.getUser().getId());
        if (song != null){
            if (songObject.getName().equals(song.getName())) {
                throw new InformationExistException("song " + song.getName() + " is already exists");
            } else {
                song.setName(songObject.getName());
                song.setLength(songObject.getLength());
                song.setReleaseDate(songObject.getReleaseDate());
                song.setUser(userDetails.getUser());
                return songRepository.save(song);
            }
        }else{
            throw new InformationNotFoundException("Cannot update song at id " + songId + " because it does not exist");
        }
    }

    public Optional<Song> deleteSong(Long songId){
        System.out.println("Service calling deleteSong ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Song song = songRepository.findByIdAndUserId(songId, userDetails.getUser().getId());
        if(song != null){
            songRepository.deleteById(songId);
            return song;
        } else{
            throw new InformationNotFoundException("song with id " + songId + " not found");
        }
    }
}
