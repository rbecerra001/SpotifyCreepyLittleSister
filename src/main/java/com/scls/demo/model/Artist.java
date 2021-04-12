package com.scls.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="artists")
public class Artist {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int monthly_streamers;

    @ManyToOne
    @JoinColumn(name="label_id")
    @JsonIgnore
    private Label label;

    @OneToMany(mappedBy = "artist", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Song> songList;

    public Artist() {
    }

    public Artist(Long id, String name, String description, int monthly_streamers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monthly_streamers = monthly_streamers;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMonthly_streamers() {
        return monthly_streamers;
    }

    public void setMonthly_streamers(int monthly_streamers) {
        this.monthly_streamers = monthly_streamers;
    }

    @Override
    public String toString() {
        return "artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", monthly_streamers=" + monthly_streamers +
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
}
