package com.example.people.user.repositories;

import com.example.people.user.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserMongoRepository extends MongoRepository<User, Integer> {
    //User findByName(String name);

}