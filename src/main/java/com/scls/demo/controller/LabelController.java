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

/*
 * A Rest Controller for the Label model.
 */
@RestController
public class LabelController {
    private LabelService labelService; // handles the business end of Label Model (separation of concerns)

    @Autowired // dependency injection
    public void setLabelService(LabelService labelService){
        this.labelService = labelService;
    }

    /*
     * http://localhost:9092/labels
     *
     * Gets all labels in label model.
     * params: none
     * returns: List<Label> - a list of Labels in the model
     */
    @GetMapping(path = "/labels")
    public List<Label> getLabels(){
        System.out.println("Calling getLabels()");
        return labelService.getLabels();
    }

    /*
     * http://localhost:9092/labels/{labelId}
     *
     * Gets a single label in label model.
     * params: Long labelId - id of label to get
     * returns: Label - a single label in the model
     */
    @GetMapping(path = "/labels/{labelId}")
    public Label getLabel(@PathVariable Long labelId){
        System.out.println("Calling getLabel()");
        return labelService.getLabel(labelId);
    }

    /*
     * http://localhost:9092/labels/{labelId}/artists
     *
     * Get all artists under a single label
     * params: Long labelId - id of label
     * returns: List<Artist> - a list of all artists under give label
     */
    @GetMapping(path = "/labels/{labelId}/artists")
    public List<Artist> getLabelArtists(@PathVariable Long labelId){
        System.out.println("Calling getLabelArtists()");
        return labelService.getLabelArtists(labelId);
    }

    /*
     * http://localhost:9092/labels/{labelId}/artists/{artistId}
     *
     * Get a single artist under a single label
     * params: Long labelId - id of label
     *         Long artistId - id of artist
     * returns: Artist - an artist with given id under given label
     */
    @GetMapping(path = "/labels/{labelId}/artists/{artistId}")
    public Artist getLabelArtist(@PathVariable Long labelId, @PathVariable Long artistId){
        System.out.println("Calling getLabelArtist()");
        return labelService.getLabelArtist(labelId, artistId);
    }

    /*
     * http://localhost:9092/labels
     *
     * Creates a single label
     * params: Label labelObject - information needed to create a label (name(required), numOfArtist, revenue)
     * returns: Label - the created Label
     */
    @PostMapping(path = "/labels")
    public Label createLabel(@RequestBody Label labelObject){
        System.out.println("Calling createLabel()");
        return labelService.createLabel(labelObject);
    }

    /*
     * http://localhost:9092/labels{labelId}
     *
     * Updates a single label
     * params: Label labelObject - information needed to update a label (name(required), numOfArtist, revenue)
     *         Long labelId - id of label to update
     * returns: Label - the updated Label
     */
    @PutMapping(path = "/labels/{labelId}")
    public Label updateLabel(@PathVariable Long labelId, @RequestBody Label labelObject){
        System.out.println("Calling updateLabel()");
        return labelService.updateLabel(labelId, labelObject);
    }

    /*
     * http://localhost:9092/labels{labelId}
     *
     * Deletes a single label and all artists and songs connected to it
     * params: Long labelId - id of label to delete
     * returns: ResponseEntity<HashMap> - a message letting the user know the label was successfully deleted
     */
    @DeleteMapping(path = "/labels/{labelId}")
    public ResponseEntity<HashMap> deleteLabel(@PathVariable Long labelId){
        System.out.println("Calling deleteLabel()");
        labelService.deleteLabel(labelId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "label with id: " + labelId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }
}
