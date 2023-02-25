package com.hazemuh.baseTemplate.controller;

import com.hazemuh.baseTemplate.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class transactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("/getData")
    public ResponseEntity getDataTesting() {
        ResponseEntity responseEntity = transactionsService.getDataTesting();
        return responseEntity;
    }

    @PostMapping("/addData")
    public ResponseEntity addData(String nama, String umur){
        ResponseEntity responseEntity = transactionsService.addData(nama,umur);
        return  responseEntity;
    }

}

