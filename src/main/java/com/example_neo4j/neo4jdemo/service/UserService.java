package com.example_neo4j.neo4jdemo.service;

import com.example_neo4j.neo4jdemo.entity.User;
import com.example_neo4j.neo4jdemo.model.UserDto;
import com.example_neo4j.neo4jdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllNodes(){
       return userRepository.findAllNodes();
    }

    public void save(User user) {

        userRepository.save(user);
    }

    public Optional<User> getUserById(Long userId) {

        return userRepository.findById(userId);
    }

    public Optional<User> findByName(String name) {

        return userRepository.findByName(name);
    }

    public User updateUser(Long id, UserDto userDto) {

        Optional<User> optionalUser= userRepository.findById(id);


      return  optionalUser.map(user->saveUser(user, userDto)).orElse(null);

    }

    private User saveUser(User user, UserDto userDto){
        user.setName(userDto.getName());
        return userRepository.save(user);
    }
}
