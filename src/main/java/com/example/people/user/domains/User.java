package com.example.people.user.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@Data
public class User {

    @Id
    @Field(value="_id")
    private String userId;

    @Field(value="user_name")
    private String userName;

    @Field(value="phone_number")
    private String phoneNumber;

    @Field(value="email_address")
    private String emailAddress;


    public User() {
    }

    public User(String userId, String userName, String phone, String email) {
       this.userId = userId;
       this.userName = userName;
       this.phoneNumber = phone;
       this.emailAddress = email;
    }


    @Override
    public String toString() {
        return "User{" +
                ", name='" + userName + '\'' +
                ", phone=" + phoneNumber +
                '}';
    }

}
