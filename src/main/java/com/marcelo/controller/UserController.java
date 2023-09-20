package com.marcelo.controller;


import com.marcelo.entity.User;
import com.marcelo.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    UserService userService;

    public UserController(UserService service) {
        this.userService =  service;
    }

    @GetMapping
    List<User> listAll(){}

    @PostMapping
    List<User> create(){}

    @DeleteMapping()
    List<User> delete(){}

    @PutMapping
    List<User> update(){}
}
