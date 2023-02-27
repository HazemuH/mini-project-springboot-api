package com.hazemuh.baseTemplate.service;
import com.hazemuh.baseTemplate.entity.Users;
import com.hazemuh.baseTemplate.repository.ReportClassRepository;
import com.hazemuh.baseTemplate.repository.transactionsRepository;
import com.hazemuh.baseTemplate.repository.usersRepository;
import com.hazemuh.baseTemplate.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersService {
   @Autowired
   private ReportClassRepository reportClassRepository;
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

    public ResponseEntity deleteUserbyId(UUID id) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            usersRepository.deleteById(id);

            msg.setStatus(true);
            msg.setMessage("Deleted!");
            result.put("usersId : ",id);
            msg.setData(result);
            return ResponseEntity.ok().body(msg);


        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }

    public ResponseEntity updateUsersbyId(Users users) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {

            Users data = usersRepository.getUsersbyId(users.getUsersId());

            users.setName((users.getName() == null) ? data.getName() : users.getName());
            users.setEmail((users.getEmail() == null) ? data.getEmail() : users.getEmail());
            users.setPassword((users.getPassword() == null) ? data.getPassword() : users.getPassword());
            users.setCreatedAt(data.getCreatedAt());
            users.setUpdatedAt(new Date());

            usersRepository.save(users);

            msg.setStatus(true);
            msg.setMessage("Updated!");
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
