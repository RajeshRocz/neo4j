package com.example_neo4j.neo4jdemo.controller;

import com.example_neo4j.neo4jdemo.entity.User;
import com.example_neo4j.neo4jdemo.model.UserDto;
import com.example_neo4j.neo4jdemo.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/save_user")
    public HttpEntity<HttpStatus> saveUser(@RequestBody User user){

        try{
            userService.save(user);
            return new HttpEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new HttpEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/get_user/{id}")
    public HttpEntity<User> getUserById(@PathVariable("id") Long userId){
        Optional<User> userById = userService.getUserById(userId);

        return userById.map(HttpEntity::new)
                .orElseThrow(() -> new RuntimeException("User Not found"));
    }

    @GetMapping("/get_user_by_name/{name}")
    public HttpEntity<User> getUserByName(@PathVariable String name){
        Optional<User> byName = userService.findByName(name);

        return byName.map(HttpEntity::new)
                .orElseThrow(()->new RuntimeException("User Not found"));
    }

    @PutMapping("/update_user/{id}")
    public HttpEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){

        User user = userService.updateUser(id, userDto);
        return new HttpEntity<>(user);
    }

}
