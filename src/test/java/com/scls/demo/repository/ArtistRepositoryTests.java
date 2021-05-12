//package com.scls.demo.repository;
//
//import com.scls.demo.model.Artist;
//import com.scls.demo.model.User;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///*
//* A class that implements JUnit tests for Artist Repository.
//* Based off code from: https://springframework.guru/testing-spring-boot-restful-services/
//*/
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class ArtistRepositoryTests {
//    @Autowired
//    private ArtistRepository artistRepository;
//    @Autowired
//    private UserRepository userRepository;
//    private Artist artist;
//    // Creates a new artist before each test
//    @BeforeEach
//    public void setUp(){
//        artist = new Artist(null, "Hannah Montana", "disney star", 500);
//    }
//
//    // Deletes everything in repository after each test
//    @AfterEach
//    public void tearDown(){
//        artistRepository.deleteAll();
//        artist = null;
//    }
//
//    /*
//     *  Tests .save() in ArtistRepository
//     */
//    @Test
//    public void testAddNewArtist(){
//       artistRepository.save(artist);
//       Artist actual = artistRepository.findById(artist.getId()).get();
//       assertNotEquals(null, actual.getId()); // makes sure when an artist is saved, they are given an id
//    }
//
//    /*
//     * Tests .findAll() in ArtistRepository
//     */
//    @Test
//    public void testFindAllArtists(){
//        Artist artist1 = new Artist(null, "Jack Johnson", "smooth", 4);
//        Artist artist2 = new Artist(null, "Rico Nasty", "fun", 7);
//        artistRepository.save(artist1);
//        artistRepository.save(artist2);
//        List<Artist> artistList = (List<Artist>) artistRepository.findAll();
//        assertEquals("Rico Nasty", artistList.get(1).getName()); // checks that second artist is Rico Nasty
//        assertEquals("Jack Johnson", artistList.get(0).getName()); // checks that first artist is Jack Johnson
//    }
//
//    /*
//     * Tests .findById() in artist repository
//     */
//    @Test
//    public void testFindProductById() {
//        Artist artist1 = new Artist(null,"Arcade Fire","hot", 590);
//        Artist artist2 = artistRepository.save(artist1);
//        Optional<Artist> optional =  artistRepository.findById(artist2.getId());
//        assertEquals(artist2.getId(), optional.get().getId());
//        assertEquals(artist2.getName(), optional.get().getName());
//    }
//
//    /*
//     * Tests .deleteById() in artist repository
//     */
//    @Test
//    public void testDeleteById() {
//        Artist artist = new Artist(null, "Doja Cat", "funny", 679);
//        artistRepository.save(artist);
//        artistRepository.deleteById(artist.getId());
//        Optional optional = artistRepository.findById(artist.getId());
//        assertEquals(Optional.empty(), optional);
//    }
//
//    /*
//     * Tests .findByUserId() in artist repository
//     */
//    @Test
//    public void testFindByUserId() {
//        Artist artist1 = new Artist(null, "Beyonce", "strong", 1000000);
//        Artist artist2 = new Artist(null, "Lizzo", "confident", 7583);
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        artist1.setUser(user);
//        artist2.setUser(user);
//        artistRepository.save(artist1);
//        artistRepository.save(artist2);
//        List<Artist> artistList = artistRepository.findByUserId(user.getId());
//        assertEquals("Lizzo", artistList.get(1).getName()); // checks that second artist is Lizzo
//        assertEquals("Beyonce", artistList.get(0).getName()); // checks that first artist Beyonce
//        artistRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//
//    /*
//     * Test .findByIdAndUserId() in artist repository
//     */
//    @Test
//    public void testFindByIdAndUserId() {
//        Artist artist1 = new Artist(null, "Megan Thee Stallion", "dope", 1000000);
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        artist1.setUser(user);
//        artistRepository.save(artist1);
//        Optional<Artist> artist2 = artistRepository.findByIdAndUserId(artist1.getId(), user.getId());
//        assertEquals("Megan Thee Stallion", artist2.get().getName()); // checks that second artist is Megan Thee Stallion
//        artistRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//}
