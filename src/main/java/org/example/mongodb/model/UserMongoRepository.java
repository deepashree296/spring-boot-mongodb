package org.example.mongodb.model;

import org.example.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, Integer> {
    User findByName(String name);
}