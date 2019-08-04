package com.rest.webservices.user;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class User {

    private Integer id; // Used Integer instead of int for null check

    @Size(min = 2,message = "Name should atleast 2 characters")
    private String name;

    @Past()
    private Date birthDate;

    protected User() {
    }

    public User(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }


}
