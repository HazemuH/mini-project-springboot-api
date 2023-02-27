package com.hazemuh.baseTemplate.controller;

import com.hazemuh.baseTemplate.entity.Transactions;
import com.hazemuh.baseTemplate.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transactions")
public class transactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("/getByUserId")
    public ResponseEntity getTransactionbyUserId(UUID user_id) {
        ResponseEntity responseEntity = transactionsService.getTransactionbyUserId(user_id);
        return responseEntity;
    }

    @GetMapping("/getById")
    public ResponseEntity getTrasactionbyTransactionId(UUID transaction_id){
        ResponseEntity responseEntity = transactionsService.getTransactionbyId(transaction_id);
        return  responseEntity;
    }

    @PostMapping("/postTransaction")
    public ResponseEntity addDataTransaction(@RequestBody Transactions transactions) {
        ResponseEntity responseEntity = transactionsService.postTransaction(transactions);
        return  responseEntity;
    }

}

