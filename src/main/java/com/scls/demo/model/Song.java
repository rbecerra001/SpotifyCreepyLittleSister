package com.scls.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table (name="songs")
public class Song {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Song() {
    }

    public Song(Long id, String name, Float length, String release_date) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.releaseDate = release_date;
    }

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
}
