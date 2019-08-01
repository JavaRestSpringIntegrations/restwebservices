package com.rest.webservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    /* In this way there is no option that
    *  we can have custom messages.
    * */
    // Over riding the exception
    public UserNotFoundException(String s) {
        super(s);
    }
}
