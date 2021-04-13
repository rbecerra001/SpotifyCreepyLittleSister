package com.scls.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/*
 * Artist Model creates a table named artists in the database
 * It has the columns: id, name, description, monthly_streamers, label_id, user_id
 */
@Entity
@Table (name="artists")
public class Artist {
    // the following are private variables which are the columns for the artist model
    @Id // Primary Key
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this will generate a unique id for each of the artists created
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int monthlyStreamers;

    // will establish a Many to One relationship for with the label model
    @ManyToOne // One artist can have one Label
    @JoinColumn(name="label_id")
    @JsonIgnore
    private Label label;

    @OneToMany(mappedBy = "artist", orphanRemoval = true)  // One Artist can have many songs
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Song> songList;

    @ManyToOne // One Artist can have one user
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    // the constructors for the artist class
    public Artist() {
    }

    public Artist(Long id, String name, String description, int monthly_streamers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monthlyStreamers = monthly_streamers;
    }

    // the following are the getters and setters for the variables in the artists class
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMonthlyStreamers() {
        return monthlyStreamers;
    }

    public void setMonthlyStreamers(int monthly_streamers) {
        this.monthlyStreamers = monthly_streamers;
    }

    @Override
    public String toString() {
        return "artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", monthly_streamers=" + monthlyStreamers +
                '}';
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
