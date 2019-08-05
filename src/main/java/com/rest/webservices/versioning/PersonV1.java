package com.rest.webservices.versioning;

import lombok.Getter;
import lombok.Setter;

//create two different versions of same service
@Getter @Setter
public class PersonV1 {
    private String name;

    public PersonV1() {
    }

    public PersonV1(String name) {
        this.name = name;
    }
}
