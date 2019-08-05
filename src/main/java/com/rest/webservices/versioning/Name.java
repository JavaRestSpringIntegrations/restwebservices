package com.rest.webservices.versioning;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Name {
    private String fname;
    private String lname;

    public Name() {

    }

    public Name(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
}


