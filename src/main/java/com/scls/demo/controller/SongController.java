package com.scls.demo.controller;

import com.scls.demo.model.Label;
import com.scls.demo.service.SongService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    private SongService songService;

    @Autowired
    public void setSongService(SongService songService){
        this.songService = songService;
    }

    //http://localhost:9092/helloworld
    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }

//    @GetMapping(path="/label")
//    public List<Label> getLabel(){
//    }
}
