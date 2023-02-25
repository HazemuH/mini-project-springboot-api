package com.hazemuh.baseTemplate.service;
import com.hazemuh.baseTemplate.entity.Transactions;
import com.hazemuh.baseTemplate.entity.Users;
import com.hazemuh.baseTemplate.repository.TestingClassRepository;
import com.hazemuh.baseTemplate.repository.transactionsRepository;
import com.hazemuh.baseTemplate.repository.usersRepository;
import com.hazemuh.baseTemplate.utility.MessageModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UsersService {
   @Autowired
   private TestingClassRepository testingClassRepository;
   @Autowired
   private transactionsRepository transactionsRepository;
   @Autowired
   private usersRepository usersRepository;


    public ResponseEntity getAllUsers() {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            List<Users> data= usersRepository.findAll();

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

    public ResponseEntity getUserbyId(UUID id) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Users data = usersRepository.getUsersbyId(id);

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

    public ResponseEntity addUser(Users users) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            usersRepository.save(users);

            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("usersId : ",users.getUsersId());
            msg.setData(result);
            return ResponseEntity.ok().body(msg);


        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }


}
