package com.hazemuh.baseTemplate.service;
import com.hazemuh.baseTemplate.entity.Transactions;
import com.hazemuh.baseTemplate.repository.ReportClassRepository;
import com.hazemuh.baseTemplate.repository.transactionsRepository;
import com.hazemuh.baseTemplate.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TransactionsService {
   @Autowired
   private ReportClassRepository reportClassRepository;
   @Autowired
   private transactionsRepository transactionsRepository;


    public ResponseEntity getTransactionbyUserId(UUID userId) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            List<Transactions> data= transactionsRepository.getTransactionbyUserId(userId);

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

    public ResponseEntity getTransactionbyId(UUID transactions_id) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Transactions data= transactionsRepository.getTransactionsbyId(transactions_id);

            if (data == null) {
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

    public ResponseEntity postTransaction(Transactions transactions) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            transactionsRepository.save(transactions);


            if (transactions.getTransactionId() == null) {
                msg.setStatus(true);
                msg.setMessage("Data tidak berhasil di save");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(true);
                msg.setMessage("Success");
                msg.setData(transactions.getTransactionId());
                return ResponseEntity.ok().body(msg);
            }


        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }



}
