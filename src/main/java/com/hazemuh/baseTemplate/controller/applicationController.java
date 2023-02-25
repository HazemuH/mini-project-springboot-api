package com.hazemuh.baseTemplate.controller;

import com.hazemuh.baseTemplate.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/browse")
public class applicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/getData")
    public ResponseEntity getDataTesting() {
        ResponseEntity responseEntity = applicationService.getDataTesting();
        return responseEntity;
    }

    @PostMapping("/addData")
    public ResponseEntity addData(String nama, String umur){
        ResponseEntity responseEntity = applicationService.addData(nama,umur);
        return  responseEntity;
    }

}

