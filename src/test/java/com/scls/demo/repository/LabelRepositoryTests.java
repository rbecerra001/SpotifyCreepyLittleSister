//package com.scls.demo.repository;
//
//import com.scls.demo.model.Genre;
//import com.scls.demo.model.Label;
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
// * A class that implements JUnit tests for Label Repository.
// * Based off code from: https://springframework.guru/testing-spring-boot-restful-services/
// */
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class LabelRepositoryTests {
//    @Autowired
//    private LabelRepository labelRepository;
//    @Autowired
//    private UserRepository userRepository;
//    private Label label;
//    // Creates a new label before each test
//    @BeforeEach
//    public void setUp(){
//        label = new Label(null, "Syco", 0, 400);
//    }
//
//    // Deletes everything in repository after each test
//    @AfterEach
//    public void tearDown(){
//        labelRepository.deleteAll();
//        label = null;
//    }
//
//    /*
//     *  Tests .save() in Label Repository
//     */
//    @Test
//    public void testAddNewLabel(){
//        labelRepository.save(label);
//        Label actual = labelRepository.findById(label.getId()).get();
//        assertNotEquals(null, actual.getId()); // makes sure when an label is saved, they are given an id
//    }
//
//    /*
//     * Tests .findAll() in Label Repository
//     */
//    @Test
//    public void testFindAllLabels(){
//        Label label1 = new Label(null, "Sony", 0, 87654);
//        Label label2 = new Label(null, "Universal", 0, 548372);
//        labelRepository.save(label1);
//        labelRepository.save(label2);
//        List<Label> labelList = (List<Label>) labelRepository.findAll();
//        assertEquals("Universal", labelList.get(1).getName()); // checks that second label is Universal
//        assertEquals("Sony", labelList.get(0).getName()); // checks that first label is Sony
//    }
//
//    /*
//     * Tests .findById() in label repository
//     */
//    @Test
//    public void testFindProductById() {
//        Label label1 = new Label(null,"Warner Music Group",0, 11111);
//        Label label2 = labelRepository.save(label1);
//        Optional<Label> optional =  labelRepository.findById(label2.getId());
//        assertEquals(label2.getId(), optional.get().getId());
//        assertEquals(label2.getName(), optional.get().getName());
//    }
//
//    /*
//     * Tests .deleteById() in label repository
//     */
//    @Test
//    public void testDeleteById() {
//        Label label = new Label(null, "Def Jams", 0, 4647483);
//        labelRepository.save(label);
//        labelRepository.deleteById(label.getId());
//        Optional optional = labelRepository.findById(label.getId());
//        assertEquals(Optional.empty(), optional);
//    }
//
//    /*
//     * Tests .findByUserId() in label repository
//     */
//    @Test
//    public void testFindByUserId() {
//        Label label1 = new Label(null, "Verve", 0,3241);
//        Label label2 = new Label(null, "Polygram", 0, 4383929);
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        label1.setUser(user);
//        label2.setUser(user);
//        labelRepository.save(label1);
//        labelRepository.save(label2);
//        List<Label> labelList = labelRepository.findByUserId(user.getId());
//        assertEquals("Polygram", labelList.get(1).getName()); // checks that second label is Polygram
//        assertEquals("Verve", labelList.get(0).getName()); // checks that first label Verve
//        labelRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//
//    /*
//     * Test .findByIdAndUserId() in Label repository
//     */
//    @Test
//    public void testFindByIdAndUserId() {
//        Label label1 = new Label(null, "Spinefarm", 0, 1203);
//        User user = new User(null, "mads", "email@gmail.com", "12345");
//        userRepository.save(user);
//        label1.setUser(user);
//        labelRepository.save(label1 );
//        Optional<Label> label2 = labelRepository.findByIdAndUserId(label1 .getId(), user.getId());
//        assertEquals("Spinefarm", label2.get().getName()); // checks that label is Spinefarm
//        labelRepository.deleteAll();
//        userRepository.deleteById(user.getId());
//    }
//}
//
