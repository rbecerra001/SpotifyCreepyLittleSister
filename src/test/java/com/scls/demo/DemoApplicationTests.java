//package com.scls.demo;
//
//import com.scls.demo.exception.InformationExistException;
//import com.scls.demo.model.Genre;
//import com.scls.demo.controller.*;
//import com.scls.demo.model.*;
//import com.scls.demo.model.request.LoginRequest;
//import com.scls.demo.model.response.LoginResponse;
//import com.scls.demo.repository.GenreRepository;
//import com.scls.demo.security.JWTUtils;
//import com.scls.demo.service.GenreService;
//import com.scls.demo.service.UserService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
///*
// * These tests are still a work in progress but they are meant to test our controllers
// */
//@ExtendWith(MockitoExtension.class)
//class GenreServiceTest {
//    @Mock
//    private GenreRepository genreRepository;
//    @Autowired
//    @InjectMocks
//    private GenreService genreService;
//    private Genre genre1;
//    private Genre genre2;
//    List<Genre> genreList;
//
//    @BeforeEach
//    public void setUp() {
//        genreList = new ArrayList<>();
//        genre1 = new Genre(null, "bread", "whole grain");
//        genre2 = new Genre(null, "jam", "pump it");
//        genreList.add(genre1);
//        genreList.add(genre2);
//    }
//
//    @AfterEach
//    public void tearDown() {
//        genre1 = genre2 = null;
//        genreList = null;
//    }
//
//    @Test
//    void givenGenreToAddShouldReturnAddedGenre() throws InformationExistException {
//        //stubbing
//        when(genreService.createGenre(any())).thenThrow(NullPointerException.class);
//        genreService.createGenre(genre1);
//        verify(genreRepository,times(0)).save(any());
//    }
//}
//
//
//// --------------------------------------------------------------------
//
//@AutoConfigureMockMvc
//@SpringBootTest
//class DemoApplicationTests {
//
//    @Autowired
//    private GenreController genreController;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private UserController userController;
//    /**Main entry point for server-side Spring MVC test support.**/
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    public void createUser() {
//        User user = new User(null, "Roger", "rbecerra@gmail.com", "6789");
//
//        User expected = user;
//        User actual = userController.createUser(user);
//        System.out.println(actual);
//
//        //assertEquals(expected, actual);
//
//    }
//
//    private static String createUserInJson (String email, String password) {
//            return "{ \"email\": \"" + email + "\", " +
//                    "\"password\":\"" + password + "\"}";
//    }
//
////    @Test
////    public void login_Success() throws Exception{
////        String login = createUserInJson("rbecerra@gmail.com","6789");
// //       LoginRequest loginRequest = new LoginRequest();
////        ResponseEntity<?> test = userService.loginUser(loginRequest);
////        RequestBuilder requestBuilder = MockMvcRequestBuilders
////                .post("/auth/users/login")
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(login);
////        when(userService.loginUser(any())).thenReturn(userService.loginUser(loginRequest));
////        MvcResult result = mockMvc.perform(requestBuilder)
////                .andExpect(status().isOk())
////                .andExpect(content().json("{\"token\":\"123456\"}"))
////                .andReturn();
////        System.out.println(result.getResponse().getContentAsString());
////    }
//
//    @Test
//    public void loginUser() {
////        LoginRequest loginRequest = new LoginRequest();
////        loginRequest.setEmail("rbecerra@gmail.com");
////        loginRequest.setPassword("6789");
////        ResponseEntity<?> actual = userController.loginUser(loginRequest);
////        System.out.println(actual.get());
//    }
//}
//
////
////    @Test
////    public void testCreateGenre(){
////        Genre genre = new Genre(null, "Jazz", "Smooth");
////        Genre actual = genreController.createGenre(genre);
////        System.out.println(actual);
////    }
////}
