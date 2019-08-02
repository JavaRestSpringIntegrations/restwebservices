package com.rest.webservices.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString
public class Post {

    private Integer id;
    private String title;
    private String content;
    private Date timestamp;

    public Post() {
    }

    public Post(Integer id, String title, String content, Date timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }
}
