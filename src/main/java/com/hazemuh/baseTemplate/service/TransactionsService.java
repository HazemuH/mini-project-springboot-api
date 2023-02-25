package com.hazemuh.baseTemplate.service;
import com.hazemuh.baseTemplate.entity.Transactions;
import com.hazemuh.baseTemplate.repository.TestingClassRepository;
import com.hazemuh.baseTemplate.repository.transactionsRepository;
import com.hazemuh.baseTemplate.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionsService {
   @Autowired
   private TestingClassRepository testingClassRepository;
   @Autowired
   private transactionsRepository transactionsRepository;


    public ResponseEntity getDataTesting() {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            List<Transactions> data= transactionsRepository.getDataTesting();

            if (data.isEmpty()) {
                msg.setStatus(true);
                msg.setMessage("Data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(true);
                msg.setMessage("Success");
                msg.setData(data);
                return ResponseEntity.ok().body(msg);
            }

        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }

    public ResponseEntity addData(String nama, String umur) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Transactions data = new Transactions();

            transactionsRepository.save(data);

            msg.setStatus(true);
            msg.setMessage("Berhasil Insert data");
            msg.setData(data);
            return ResponseEntity.ok().body(msg);


        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }



}
