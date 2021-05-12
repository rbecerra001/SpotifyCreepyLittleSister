//package com.scls.demo.repository;
//
//import com.scls.demo.model.Artist;
//import com.scls.demo.model.Genre;
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
// * A class that implements JUnit tests for Genre Repository.
// * Based off code from: https://springframework.guru/testing-spring-boot-restful-services/
// */
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class GenreRepositoryTests {
//    @Autowired
//    private GenreRepository genreRepository;
//    @Autowired
//    private UserRepository userRepository;
//    private Genre genre;
//    // Creates a new genre before each test
//    @BeforeEach
//    public void setUp(){
//        genre = new Genre(null, "Hip-Hop", "dope");
//    }
//
//    // Deletes everything in repository after each test
//    @AfterEach
//    public void tearDown(){
//        genreRepository.deleteAll();
//        genre = null;
//    }
//
//    /*
//     *  Tests .save() in GenreRepository
//     */
//    @Test
//    public void testAddNewGenre(){
//        genreRepository.save(genre);
//        Genre actual = genreRepository.findById(genre.getId()).get();
//        assertNotEquals(null, actual.getId()); // makes sure when an genre is saved, they are given an id
//    }
//
//    /*
//     * Tests .findAll() in Genre Repository
//     */
//    @Test
//    public void testFindAllGenres(){
//        Genre genre1 = new Genre(null, "Jazz", "smooth");
//        Genre genre2 = new Genre(null, "Pop", "fun");
//        genreRepository.save(genre1);
//        genreRepository.save(genre2);
//        List<Genre> genreList = (List<Genre>) genreRepository.findAll();
//        assertEquals("Pop", genreList.get(1).getName()); // checks that second genre is Pop
//        assertEquals("Jazz", genreList.get(0).getName()); // checks that first genre is Jazz
//    }
//
//    /*
//     * Tests .findById() in genre repository
//     */
//    @Test
//    public void testFindProductById() {
//        Genre genre1 = new Genre(null,"Reggae","hot");
//        Genre genre2 = genreRepository.save(genre1);
//        Optional<Genre> optional =  genreRepository.findById(genre2.getId());
//        assertEquals(genre2.getId(), optional.get().getId());
//        assertEquals(genre2.getName(), optional.get().getName());
//    }
//
//    /*
//     * Tests .deleteById() in genre repository
//     */
//    @Test
//    public void testDeleteById() {
//        Genre genre = new Genre(null, "Electronic", "beep-boop");
//        genreRepository.save(genre);
//        genreRepository.deleteById(genre.getId());
//        Optional optional = genreRepository.findById(genre.getId());
//        assertEquals(Optional.empty(), optional);
//    }
//
//    /*
//     * Tests .findByUserId() in genre repository
//     */
//    @Test
//    public void testFindByUserId() {
//        Genre genre1 = new Genre(null, "Classic Rock", "throwback");
//        Genre genre2 = new Genre(null, "Alt Rock", "og");
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        genre1.setUser(user);
//        genre2.setUser(user);
//        genreRepository.save(genre1);
//        genreRepository.save(genre2);
//        List<Genre> genreList = genreRepository.findByUserId(user.getId());
//        assertEquals("Alt Rock", genreList.get(1).getName()); // checks that second genre is Alt Rock
//        assertEquals("Classic Rock", genreList.get(0).getName()); // checks that first genre Classic Rock
//        genreRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//
//    /*
//     * Test .findByIdAndUserId() in genre repository
//     */
//    @Test
//    public void testFindByIdAndUserId() {
//        Genre genre1 = new Genre(null, "Classical", "light");
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        genre1.setUser(user);
//        genreRepository.save(genre1);
//        Genre genre2 = genreRepository.findByIdAndUserId(genre1.getId(), user.getId());
//        assertEquals("Classical", genre2.getName()); // checks that genre is Megan Thee Stallion
//        genreRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//
//    /*
//     * Test .findByUserIdAndName() in genre repository
//     */
//    @Test
//    public void testfindByUserIdAndName() {
//        Genre genre1 = new Genre(null, "Kpop", "light");
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        genre1.setUser(user);
//        genreRepository.save(genre1);
//        Genre genre2 = genreRepository.findByUserIdAndName(user.getId(), "Kpop");
//        assertEquals("light", genre2.getDescription()); // checks that genre is correct
//        genreRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//}
