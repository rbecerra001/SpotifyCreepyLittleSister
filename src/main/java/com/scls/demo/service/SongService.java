package com.scls.demo.service;

import com.scls.demo.exception.InformationNotFoundException;
import com.scls.demo.model.Artist;
import com.scls.demo.model.Genre;
import com.scls.demo.model.Song;
import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return songRepository.findAll();
    }

    public Song getSong(Long songId){
        System.out.println("Service calling getSong ==>");
        Song song = songRepository.findById(songId).get();
        if(song == null){
            throw new InformationNotFoundException("Song with id: " + songId + "does not exist.");
        } else {
            return song;
        }
    }

    public Song createSong(Long artistId, Long genreId, Song songObject){
        System.out.println("Service calling createSong ==>");
        Optional<Artist> artist = artistRepository.findById(artistId);
        if(artist.isPresent()){
            Optional<Genre> genre = genreRepository.findById(genreId);
            if(genre.isPresent()){
                songObject.setArtist(artist.get());
                songObject.setGenre(genre.get());
                return songRepository.save(songObject);
            } else {
                throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
            }
        } else {
            throw new InformationNotFoundException("Artist with id " + artistId + " does not exist");
        }
    }

    public Song updateSong(Long songId, Song songObject){
        System.out.println("Service calling updateSong ==>");
        Optional<Song> song = songRepository.findById(songId);
        if(song.isPresent()){
            Song updateSong = songRepository.findById(songId).get();
            updateSong.setName(songObject.getName());
            updateSong.setLength(songObject.getLength());
            updateSong.setRelease_date(songObject.getRelease_date());
            return songRepository.save(updateSong);
        } else {
            throw new InformationNotFoundException("Song with id " + songId + " does not exist");
        }
    }

    public Optional<Song> deleteSong(Long songId){
        System.out.println("Service calling deleteSong ==>");
        Optional<Song> song = songRepository.findById(songId);
        if(song.isPresent()){
            songRepository.deleteById(songId);
            return song;
        } else {
            throw new InformationNotFoundException("Song with id " + songId + " does not exist");
        }
    }
}
