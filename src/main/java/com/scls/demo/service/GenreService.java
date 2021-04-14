package com.scls.demo.service;

import com.scls.demo.exception.InformationExistException;
import com.scls.demo.exception.InformationNotFoundException;
import com.scls.demo.model.Genre;
import com.scls.demo.model.Song;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.repository.SongRepository;
import com.scls.demo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getUser());
        List<Genre> genres = genreRepository.findByUserId(userDetails.getUser().getId());
        if(genres.isEmpty()){
            throw new InformationNotFoundException("no genres found for that user id" + userDetails.getUser().getId());
        } else{
            return genres;
        }
    }

    public Genre getGenre(Long genreId){
        System.out.println("Service calling getGenre ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if(genre == null){
            throw new InformationNotFoundException("genre with id" + genreId + " not found");
        } else {
            return genre;
        }
    }

    public List<Song> getSongsinGenre(Long genreId){
        System.out.println("Service calling getSongsinGenre ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if (genre != null) {
            return genre.getSongList();
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " not found");
        }
    }

    public Song getSonginGenre(Long genreId, Long songId){
        System.out.println("Service calling getSonginGenre ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if (genre != null) {
            Optional<Song> song = songRepository.findByGenreIdAndUserId(genreId, userDetails.getUser().getId()).stream().filter(
                    p -> p.getId().equals(songId)).findFirst();
            if (song.isEmpty()) {
                throw new InformationNotFoundException("song with id " + songId + " not found");
            } else {
                return song.get();
            }
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + " not found");
        }
    }

    public Genre createGenre(Genre genreObject){
        System.out.println("Service calling createGenre ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByUserIdAndName(userDetails.getUser().getId(), genreObject.getName());
        if (genre != null){
            throw new InformationExistException("Genre with name " + genreObject.getName() + " already exists");
        }else{
            genreObject.setUser(userDetails.getUser());
            return genreRepository.save(genreObject);
        }
    }

    public Genre updateGenre(Long genreId, Genre genreObject){
        System.out.println("Service calling updateGenre ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if (genre != null){
            if (genreObject.getName().equals(genre.getName())) {
                throw new InformationExistException("genre " + genre.getName() + " is already exists");
            } else {
                genre.setName(genreObject.getName());
                genre.setDescription(genreObject.getDescription());
                genre.setUser(userDetails.getUser());
                return genreRepository.save(genre);
            }
        }else{
            throw new InformationNotFoundException("Cannot update genre at id " + genreId + " because it does not exist");
        }
    }

    public Genre deleteGenre(Long genreId){
        System.out.println("Service calling deleteGenre ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Genre genre = genreRepository.findByIdAndUserId(genreId, userDetails.getUser().getId());
        if(genre != null){
            genreRepository.deleteById(genreId);
            return genre;
        } else{
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }
}
