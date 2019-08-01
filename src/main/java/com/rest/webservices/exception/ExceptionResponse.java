package com.rest.webservices.exception;

import lombok.Getter;

import java.util.Date;

@Getter
public class ExceptionResponse {

    // == Define structure for your exception response ==
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
