package com.example_neo4j.neo4jdemo.controller;

import com.example_neo4j.neo4jdemo.entity.User;
import com.example_neo4j.neo4jdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/graphdb")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllNodes")
    public List<User> getAllNodes(){
        return userService.findAllNodes();
    }

}
