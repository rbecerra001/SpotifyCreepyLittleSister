package com.scls.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="labels")
public class Label {

    // the following are private variables which are the columns for the label model

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this will generate a unique id for each of the artists created
    private Long id;

    @Column
    private String name;

    @Column
    private int numOfArtists;

    @Column
    private int revenue;

    @OneToMany(mappedBy = "label", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Artist> artistList;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    public Label() {
    }

    // the constructors for the label class
    public Label(Long id, String name, int numOfArtists, int revenue) {
        this.id = id;
        this.name = name;
        this.numOfArtists = numOfArtists;
        this.revenue = revenue;
    }

    // the following are the getters and setters for the variables in the label class

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

    public int getNumOfArtists() {
        return numOfArtists;
    }

    public void setNumOfArtists(int num_of_artists) {
        this.numOfArtists = num_of_artists;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num_of_artists=" + numOfArtists +
                ", revenue=" + revenue +
                '}';
    }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
