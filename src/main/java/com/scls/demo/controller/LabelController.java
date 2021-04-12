package com.scls.demo.controller;

import com.scls.demo.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabelController {
    private LabelService labelService;

    @Autowired
    public void setLabelService(LabelService labelService){
        this.labelService = labelService;
    }
}