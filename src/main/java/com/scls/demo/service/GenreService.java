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
        Genre genre = genreRepository.findById(genreId);
        if(genre == null){
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
        } else {
            return genre;
        }
    }

    public Song getSongsinGenre(Long genreId){
        System.out.println("Service calling getSongsinGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            return genre.get().getSongList();
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
        }
    }

    public Song getSonginGenre(Long genreId, Long songId){
        System.out.println("Service calling getSonginGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            Optional<Song> song = songRepository.findById(songId);
            if(song.isPresent()){
                return song;
            } else {
                throw new InformationNotFoundException("Song with id: " + songId + "does not exist.");
            }
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
        }
    }

    public Genre createGenre(Genre genreObject){
        System.out.println("Service calling createGenre ==>");
        Genre genre = createGenre(genreObject);
        genre.setName(genre.getName());
        genre.setDescription(genre.getDescription());
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Long genreId, Genre genreObject){
        System.out.println("Service calling updateGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            Genre updateGenre = genreRepository.findById(genreId).get();
            updateGenre.setName(genreObject.getName());
            updateGenre.setDescription(genreObject.getDescription());
            return genreRepository.save(updateGenre);
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
        }
    }

    public Optional<Genre> deleteGenre(Long genreId){
        System.out.println("Service calling deleteGenre ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if(genre.isPresent()){
            genreRepository.deleteById(genreId);
            return genre;
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " does not exist");
        }
    }
}
