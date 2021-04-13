package com.scls.demo.service;

import com.scls.demo.exception.InformationNotFoundException;
import com.scls.demo.model.Artist;
import com.scls.demo.model.Label;
import com.scls.demo.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * LabelService implements the business logic for LabelController.
 */
@Service
public class LabelService {
    private LabelRepository labelRepository;

    @Autowired // dependencty injection
    public void setLabelRepository(LabelRepository labelRepository){
        this.labelRepository = labelRepository;
    }

    /*
     * Gets all labels in label model.
     * params: none
     * returns: List<Label> - a list of Labels in the model. If there are no labels, an empty list is returned.
     */
    public List<Label> getLabels(){
        System.out.println("Calling getLabels() in service");
        return labelRepository.findAll();
    }

    /*
     * Gets a single label in label model.
     * params: Long labelId - id of label to get
     * returns: Label - a single label in the model. Throws an exception if the label doesn't exist.
     */
    public Label getLabel(Long labelId){
        System.out.println("Calling getLabel() in service");
        Optional<Label> label = labelRepository.findById(labelId);
        if(label.isPresent()){
            return label.get();
        }else{
            throw new InformationNotFoundException("Label with id " + labelId + " does not exist");
        }
    }

    /*
     * Get all artists under a single label
     * params: Long labelId - id of label
     * returns: List<Artist> - a list of all artists under give label
     */
    public List<Artist> getLabelArtists(Long labelId){
        System.out.println("Calling getLabelArtists() in service");
        Label label = getLabel(labelId);
        return label.getArtistList();
    }

    /*
     * Get a single artist under a single label
     * params: Long labelId - id of label
     *         Long artistId - id of artist
     * returns: Artist - an artist with given id under given label. Throws an exception if the artists doesn't exist.
     */
    public Artist getLabelArtist(Long labelId, Long artistId){
        System.out.println("Calling getLabelArtist() in service");
        Optional<Artist> artist = getLabelArtists(labelId).stream().filter(a -> a.getId().equals(artistId)).findFirst();
        if(artist.isPresent()){
            return artist.get();
        }else{
            throw new InformationNotFoundException("Artist with id " + artistId + " does not exist in label with id " + labelId);
        }
    }

    /*
     * Creates a single label
     * params: Label labelObject - information needed to create a label (name(required), numOfArtist, revenue)
     * returns: Label - the created Label
     */
    public Label createLabel(Label labelObject){
        System.out.println("Calling createLabel() in service");
        return labelRepository.save(labelObject);
    }

    /*
     * Updates a single label
     * params: Label labelObject - information needed to update a label (name(required), numOfArtist, revenue)
     *         Long labelId - id of label to update
     * returns: Label - the updated Label
     */
    public Label updateLabel(Long labelId, Label labelObject){
        System.out.println("Calling updateLabel() in service");
        Label label = getLabel(labelId);
        label.setName(labelObject.getName());
        label.setNumOfArtists(labelObject.getNumOfArtists());
        label.setRevenue(labelObject.getRevenue());
        return labelRepository.save(label);
    }

    /*
     * Deletes a single label and throws an error if the label doesn't exist
     * params: Long labelId - id of label to delete
     * returns: None
     */
    public void deleteLabel(Long labelId){
        System.out.println("Calling deleteLabel() in service");
        if(labelRepository.findById(labelId).isPresent()){
            labelRepository.deleteById(labelId);
        }else{
            throw new InformationNotFoundException("Label with id " + labelId + " does not exist ");
        }
    }
}
