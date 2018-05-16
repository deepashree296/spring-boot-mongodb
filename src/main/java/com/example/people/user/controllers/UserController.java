package com.example.people.user.controllers;

import com.example.people.user.models.User;
import com.example.people.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(
            value="/findUser",
            method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<User>> findPeopleUsers() {

        Collection<User> peopleUsers = userService.getAllUsers();
        return  new ResponseEntity<Collection<User>>(peopleUsers, HttpStatus.OK);

    }


    @RequestMapping(
            value="/user",
            method=RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> peopleUserOnboarding(@RequestBody User user ) {
        User newUser = userService.createUser(user);
        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);

    }

}
