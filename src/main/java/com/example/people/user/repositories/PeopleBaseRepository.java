package com.example.people.user.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface PeopleBaseRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {

    Optional<T> findById(ID id);

    <S extends T> S save(S entity);
}

