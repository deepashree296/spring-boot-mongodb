package com.example.people.user.services;

import com.example.people.user.models.User;
import com.example.people.user.repositories.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMongoRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> peopleUsers = new ArrayList<>();
        userRepository.findAll().forEach(peopleUsers::add);
        return peopleUsers;
    }

    @Override
    public User createUser(User newUser) {
        userRepository.save(newUser);
        return newUser;
    }
}
