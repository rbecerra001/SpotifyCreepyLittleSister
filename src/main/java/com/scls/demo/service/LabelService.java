package com.scls.demo.service;

import com.scls.demo.exception.InformationExistException;
import com.scls.demo.exception.InformationNotFoundException;
import com.scls.demo.model.Artist;
import com.scls.demo.model.Label;
import com.scls.demo.repository.ArtistRepository;
import com.scls.demo.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {

    private ArtistRepository artistRepository;
    private LabelRepository labelRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    @Autowired
    public void setLabelRepository(LabelRepository labelRepository){
        this.labelRepository = labelRepository;
    }

    public List<Label> getLabels(){
        System.out.println("Calling getLabels() in service");
        return labelRepository.findAll();
    }

    public Label getLabel(Long labelId){
        System.out.println("Calling getLabel() in service");
        Optional<Label> label = labelRepository.findById(labelId);
        if(label.isPresent()){
            return label.get();
        }else{
            throw new InformationNotFoundException("Label with id " + labelId + " does not exist");
        }
    }

    public List<Artist> getLabelArtists(Long labelId){
        System.out.println("Calling getLabelArtists() in service");
        Label label = getLabel(labelId);
        return label.getArtistList();
    }

    public Artist getLabelArtist(Long labelId, Long artistId){
        System.out.println("Calling getLabelArtist() in service");
        Optional<Artist> artist = getLabelArtists(labelId).stream().filter(a -> a.getId().equals(artistId)).findFirst();
        if(artist.isPresent()){
            return artist.get();
        }else{
            throw new InformationNotFoundException("Artist with id " + artistId + " does not exist in label with id " + labelId);
        }
    }

    public Label createLabel(Label labelObject){
        System.out.println("Calling createLabel() in service");
        return labelRepository.save(labelObject);
    }

    public Label updateLabel(Long labelId, Label labelObject){
        System.out.println("Calling updateLabel() in service");
        Label label = getLabel(labelId);
        label.setName(labelObject.getName());
        label.setNumOfArtists(labelObject.getNumOfArtists());
        label.setRevenue(labelObject.getRevenue());
        return labelRepository.save(label);
    }

    public void deleteLabel(Long labelId){
        System.out.println("Calling deleteLabel() in service");
        if(labelRepository.findById(labelId).isPresent()){
            labelRepository.deleteById(labelId);
        }else{
            throw new InformationNotFoundException("Label with id " + labelId + " does not exist ");
        }
    }
}
