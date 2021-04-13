package com.scls.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table (name="songs")
public class Song {

    // the following are private variables which are the columns for the songs model

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this will generate a unique id for each of the artists created
    private Long id;

    @Column
    private String name;

    @Column
    private Float length;

    @Column
    private String releaseDate;

    @ManyToOne
    @JoinColumn(name="artist_id")
    @JsonIgnore
    private Artist artist;

    @ManyToOne
    @JoinColumn(name="genre_id")
    @JsonIgnore
    private Genre genre;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    public Song() {
    }

    // the constructors for the song class
    public Song(Long id, String name, Float length, String release_date) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.releaseDate = release_date;
    }

    // the following are the getters and setters for the variables in the songs class
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String release_date) {
        this.releaseDate = release_date;
    }

    public void setGenre(Genre genre){this.genre = genre;}

    public Genre getGenre(){return genre;}

    @Override
    public String toString() {
        return "song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", release_date='" + releaseDate + '\'' +
                '}';
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
