package com.scls.demo.repository;

import com.scls.demo.model.Artist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ArtistRepositoryTests {
    @Autowired
    private ArtistRepository artistRepository;
    private Artist artist;
    // Creates a new artist before each test
    @BeforeEach
    public void setUp(){
        artist = new Artist(null, "Hannah Montana", "disney star", 500);
    }

    // Deletes everything in repository after each test
    @AfterEach
    public void tearDown(){
        artistRepository.deleteAll();
        artist = null;
    }
    @Test
    public void testAddNewArtist(){
       artistRepository.save(artist);
       Artist actual = artistRepository.findById(artist.getId()).get();
       assertNotEquals(null, actual.getId());
    }

}
