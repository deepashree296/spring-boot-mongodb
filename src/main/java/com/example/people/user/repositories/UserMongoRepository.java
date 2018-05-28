package com.example.people.user.repositories;

import com.example.people.user.domains.User;
import org.springframework.lang.NonNull;

import java.util.Optional;


public interface UserMongoRepository extends PeopleBaseRepository<User, String> {

    // declare query methods on domain User ( id type is String)
    User findByPhoneNumber(String phoneNumber);

}