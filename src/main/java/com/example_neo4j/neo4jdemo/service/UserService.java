package com.example_neo4j.neo4jdemo.service;

import com.example_neo4j.neo4jdemo.entity.User;
import com.example_neo4j.neo4jdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllNodes(){
       return userRepository.findAllNodes();
    }
}
