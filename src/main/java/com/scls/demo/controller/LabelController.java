package com.scls.demo.controller;

import com.scls.demo.model.Artist;
import com.scls.demo.model.Label;
import com.scls.demo.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class LabelController {
    private LabelService labelService;

    @Autowired
    public void setLabelService(LabelService labelService){
        this.labelService = labelService;
    }

    // http://localhost:9092/labels
    @GetMapping(path = "/labels")
    public List<Label> getLabels(){
        System.out.println("Calling getLabels()");
        return labelService.getLabels();
    }
    // http://localhost:9092/labels/{labelId}
    @GetMapping(path = "/labels/{labelId}")
    public Label getLabel(@PathVariable Long labelId){
        System.out.println("Calling getLabel()");
        return labelService.getLabel(labelId);
    }
    // http://localhost:9092/labels/{labelId}/artists
    @GetMapping(path = "/labels/{labelId}/artists")
    public List<Artist> getLabelArtists(@PathVariable Long labelId){
        System.out.println("Calling getLabelArtists()");
        return labelService.getLabelArtists(labelId);
    }
    // http://localhost:9092/labels/{labelId}/artists/{artistId}
    @GetMapping(path = "/labels/{labelId}/artists/{artistId}")
    public Artist getLabelArtist(@PathVariable Long labelId, @PathVariable Long artistId){
        System.out.println("Calling getLabelArtist()");
        return labelService.getLabelArtist(labelId, artistId);
    }
    // http://localhost:9092/labels
    @PostMapping(path = "/labels")
    public Label createLabel(@RequestBody Label labelObject){
        System.out.println("Calling createLabel()");
        return labelService.createLabel(labelObject);
    }
    // http://localhost:9092/labels{labelId}
    @PutMapping(path = "/labels/{labelId}")
    public Label updateLabel(@PathVariable Long labelId, @RequestBody Label labelObject){
        System.out.println("Calling updateLabel()");
        return labelService.updateLabel(labelId, labelObject);
    }
    // http://localhost:9092/labels/{labelId}
    @DeleteMapping(path = "/labels/{labelId}")
    public ResponseEntity<HashMap> deleteLabel(@PathVariable Long labelId){
        System.out.println("Calling deleteLabel()");
        labelService.deleteLabel(labelId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "label with id: " + labelId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }
}
