//package com.scls.demo.repository;
//
//import com.scls.demo.model.Genre;
//import com.scls.demo.model.Song;
//import com.scls.demo.model.Song;
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
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
///*
// * A class that implements JUnit tests for Song Repository.
// * Based off code from: https://springframework.guru/testing-spring-boot-restful-services/
// */
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class SongRepositoryTests {
//    @Autowired
//    private SongRepository songRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private GenreRepository genreRepository;
//    private Song song;
//    // Creates a new song before each test
//    @BeforeEach
//    public void setUp(){
//        song = new Song(null, "500 Miles", (float)2.3, "January 4th");
//    }
//
//    // Deletes everything in repository after each test
//    @AfterEach
//    public void tearDown(){
//        songRepository.deleteAll();
//        song = null;
//    }
//
//    /*
//     *  Tests .save() in Song Repository
//     */
//    @Test
//    public void testAddNewSong(){
//        songRepository.save(song);
//        Song actual = songRepository.findById(song.getId()).get();
//        assertNotEquals(null, actual.getId()); // makes sure when an song is saved, they are given an id
//    }
//
//    /*
//     * Tests .findAll() in song Repository
//     */
//    @Test
//    public void testFindAllSongs(){
//        Song song1 = new Song(null, "Waterloo", (float)5.4, "March 15th");
//        Song song2 = new Song(null, "Baby", (float)3.2, "March 9th");
//        songRepository.save(song1);
//        songRepository.save(song2);
//        List<Song> songList = (List<Song>) songRepository.findAll();
//        assertEquals("Baby", songList.get(1).getName()); // checks that second song is Baby
//        assertEquals("Waterloo", songList.get(0).getName()); // checks that first song is Waterloo
//    }
//
//    /*
//     * Tests .findById() in Song repository
//     */
//    @Test
//    public void testFindProductById() {
//        Song song1 = new Song(null,"Hold Up", (float)1.5, "May 8th");
//        Song song2 = songRepository.save(song1);
//        Optional<Song> optional =  songRepository.findById(song2.getId());
//        assertEquals(song2.getId(), optional.get().getId());
//        assertEquals(song2.getName(), optional.get().getName());
//    }
//
//    /*
//     * Tests .deleteById() in song repository
//     */
//    @Test
//    public void testDeleteById() {
//        Song song = new Song(null, "Like a Girl", (float)3.45, "August 10th");
//        songRepository.save(song);
//        songRepository.deleteById(song.getId());
//        Optional optional = songRepository.findById(song.getId());
//        assertEquals(Optional.empty(), optional);
//    }
//    /*
//     * Tests .findByUserId() in song repository
//     */
//    @Test
//    public void testFindByUserId() {
//        Song song1 = new Song(null, "MONTERO", (float)2.1, "February 20th");
//        Song song2 = new Song(null, "Maniac", (float)3.21, "August 20th");
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        song1.setUser(user);
//        song2.setUser(user);
//        songRepository.save(song1);
//        songRepository.save(song2);
//        List<Song> songList = songRepository.findByUserId(user.getId());
//        assertEquals("Maniac", songList.get(1).getName()); // checks that second song is Maniac
//        assertEquals("MONTERO", songList.get(0).getName()); // checks that first song MONTERO
//        songRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//
//    /*
//     * Test .findByIdAndUserId() in Song repository
//     */
//    @Test
//    public void testFindByIdAndUserId() {
//        Song song1 = new Song(null, "Motivation", (float)5.4, "March 17th");
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        song1.setUser(user);
//        songRepository.save(song1 );
//        Song song2 = songRepository.findByIdAndUserId(song1 .getId(), user.getId());
//        assertEquals("Motivation", song2.getName()); // checks that song is Motivation
//        songRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//
//    /*
//     * Test .findByNameAndUserId() in song repository
//     */
//    @Test
//    public void testFindByNameAndUserId() {
//        Song song1 = new Song(null, "Dirty", (float)5.4, "September 4th");
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        song1.setUser(user);
//        songRepository.save(song1);
//        Song song2 = songRepository.findByNameAndUserId("Dirty", user.getId());
//        assertEquals("September 4th", song2.getReleaseDate()); // checks that song is the correct one
//        songRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//
//    /*
//     * Test .findByGenreIdAndUserId() in song repository
//     */
//    @Test
//    public void testFindByGenreIdAndUserId() {
//        Song song1 = new Song(null, "NASA", (float)3.5, "October 31st");
//        Song song2 = new Song(null, "Blank Space", (float)3.2, "Decemeber 25th");
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        Genre genre = new Genre(null, "Pop", "favorite");
//        userRepository.save(user);
//        genreRepository.save(genre);
//        song1.setUser(user);
//        song1.setGenre(genre);
//        songRepository.save(song1);
//        song2.setUser(user);
//        song2.setGenre(genre);
//        songRepository.save(song2);
//        List<Song> songList = songRepository.findByGenreIdAndUserId(genre.getId(), user.getId());
//        System.out.println(songList);
//        assertEquals(song1.getId(), songList.get(0).getId()); // checks first song has correct id
//        assertEquals(song2.getId(), songList.get(1).getId()); // checks second song has correct id
//        songRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//}
//
//
