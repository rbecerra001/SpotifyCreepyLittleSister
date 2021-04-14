package com.scls.demo;

import com.scls.demo.exception.InformationExistException;
import com.scls.demo.model.Genre;
import com.scls.demo.controller.*;
import com.scls.demo.model.*;
import com.scls.demo.model.Request.*;
import com.scls.demo.repository.GenreRepository;
import com.scls.demo.service.GenreService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private GenreRepository genreRepository;
    @Autowired
    @InjectMocks
    private GenreService genreService;
    private Genre genre1;
    private Genre genre2;
    List<Genre> genreList;

    @BeforeEach
    public void setUp() {
        genreList = new ArrayList<>();
        genre1 = new Genre(null, "bread", "whole grain");
        genre2 = new Genre(null, "jam", "pump it");
        genreList.add(genre1);
        genreList.add(genre2);
    }

    @AfterEach
    public void tearDown() {
        genre1 = genre2 = null;
        genreList = null;
    }

    @Test
    void givenGenreToAddShouldReturnAddedGenre() throws InformationExistException {
        //stubbing
        when(genreRepository.save(any())).thenReturn(genre1);
        genreService.createGenre(genre1);
        verify(genreRepository,times(1)).save(any());
    }
}


// --------------------------------------------------------------------

//@SpringBootTest
//class DemoApplicationTests {
//
//    @Autowired
//    private GenreController genreController;
//
//    @Autowired
//    private UserController userController;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    public void createUser(){
//        User user = new User(null, "Roger", "rbecerra@gmail.com", "6789");
//
//        User expected = user;
//        User actual = userController.createUser(user);
//        System.out.println(actual);
//
//        assertEquals(expected, actual);
//
//    }
//
//    @Test
//    public void loginUser(){
//        LoginRequest loginRequest = new LoginRequest();
//        User expected = user;
//        User actual = userController.createUser(user);
//        System.out.println(actual);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testCreateGenre(){
//        Genre genre = new Genre(null, "Jazz", "Smooth");
//        Genre actual = genreController.createGenre(genre);
//        System.out.println(actual);
//    }
//}
