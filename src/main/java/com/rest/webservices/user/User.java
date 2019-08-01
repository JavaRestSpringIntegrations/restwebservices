package com.rest.webservices.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private Integer id; // Used Integer instead of int for null check
    private String name;
    private Date birthDate;

    protected User() {
    }

    public User(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }


}
