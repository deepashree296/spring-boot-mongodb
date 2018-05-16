package com.example.people.user.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {

    @Id
    private String _userID;

    private String name;

    private String phone_number;

    private String email_address;


    public User() {
    }

    public User(String user_id, String username, String phone, String email) {
       this._userID = user_id;
       this.name = username;
       this.phone_number = phone;
       this.email_address = email;
    }


    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", phone=" + phone_number +
                '}';
    }

}
