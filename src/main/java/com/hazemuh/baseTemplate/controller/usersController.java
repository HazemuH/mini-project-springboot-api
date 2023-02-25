package com.hazemuh.baseTemplate.controller;

import com.hazemuh.baseTemplate.entity.Users;
import com.hazemuh.baseTemplate.service.TransactionsService;
import com.hazemuh.baseTemplate.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class usersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/all")
    public ResponseEntity getDataTesting() {
        ResponseEntity responseEntity = usersService.getAllUsers();
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity getDatabyId(@PathVariable("id") UUID id) {
        ResponseEntity responseEntity = usersService.getUserbyId(id);
        return responseEntity;
    }

    @PostMapping("/addUsers")
    public ResponseEntity addUsers(@RequestBody Users users) {
        ResponseEntity responseEntity = usersService.addUser(users);
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable UUID id) {
        ResponseEntity responseEntity = usersService.deleteUserbyId(id);
        return responseEntity;
    }

    @PutMapping("/updateUsers")
    public ResponseEntity updateById(@RequestBody Users users) {
        ResponseEntity responseEntity = usersService.updateUsersbyId(users);
        return responseEntity;
    }


}

