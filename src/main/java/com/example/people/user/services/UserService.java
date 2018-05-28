package com.example.people.user.services;

import com.example.people.user.domains.User;

import java.util.List;

public interface UserService {

    // get all instances of user
    List<User> getAllUsers();

    // create a people user with no connection data
    User createUser(User newUser);

    // find user by phone number
    User getUserByNumber(String phoneNumber);







}


