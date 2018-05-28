package com.example.people.user.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "connections")
@Data
public class Connections {

    @Id
    @Field(value="_id")
    private String connectionId;

    @Field(value="from_user")
    private String connectionFrom;

    @Field(value="to_user")
    private String connectedTo;

    @Field(value="is_static")
    private String isStatic;


    public Connections() {
    }

}
