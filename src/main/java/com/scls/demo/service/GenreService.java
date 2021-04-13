package com.scls.demo.service;

import com.scls.demo.exception.InformationNotFoundException;
import com.scls.demo.model.Genre;
import com.scls.demo.model.Song;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Genre> getGenres(){
        System.out.println("calling getGenres ==>");
        return genreRepository.findAll();
    }

    public Genre getGenre(Long genreId){
        System.out.println("Service calling getGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
        // checks if there's a genre with the requested ID
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
            // if no genre with that ID exists, throws an exception
        } else {
            return genre.get();
            // if a genre with that ID does exist, then it'll return it
        }
    }

    public List<Song> getSongsinGenre(Long genreId){
        System.out.println("Service calling getSongsinGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
        // checks to see if there is a genre with the requested ID
            return genre.get().getSongList();
            // if it exists, it'll return all songs in the genre
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
            // if no genre with ID exists then an exception error is thrown
        }
    }

    public Song getSonginGenre(Long genreId, Long songId){
        System.out.println("Service calling getSonginGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
        // checks to see if there is a genre with the requested ID
            Optional<Song> song = songRepository.findById(songId);
            if(song.isPresent()){
            // checks to see if there is a song with the requested ID
                return song.get();
                // if it does exist, then till return that song
            } else {
                throw new InformationNotFoundException("Song with id: " + songId + "does not exist.");
                // if no song with ID exists then an exception error is thrown
            }
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
            // if no genre with ID exists then an exception error is thrown
        }
    }

    public Genre createGenre(Genre genreObject){
        System.out.println("Service calling createGenre ==>");
        return genreRepository.save(genreObject);
    }

    public Genre updateGenre(Long genreId, Genre genreObject){
        System.out.println("Service calling updateGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
        // checks to see if there is a genre with the requested ID
            Genre updateGenre = genreRepository.findById(genreId).get();
            updateGenre.setName(genreObject.getName());
            updateGenre.setDescription(genreObject.getDescription());
            return genreRepository.save(updateGenre);
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
            // if no genre with ID exists then an exception error is thrown
        }
    }

    public Optional<Genre> deleteGenre(Long genreId){
        System.out.println("Service calling deleteGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
        // checks to see if there is a genre with the requested ID
            genreRepository.deleteById(genreId);
            return genre;
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
            // if no genre with ID exists then an exception error is thrown
        }
    }
}
