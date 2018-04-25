package org.example.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {

    @Id
    private String id;

    private String name;

    private int age;


    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", Age=" + age +
                '}';
    }

}
