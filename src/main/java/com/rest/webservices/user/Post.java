package com.rest.webservices.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
@ToString
public class Post {

    private Integer id;
    private String title;
    private String content;
    private Date timestamp;


    public Post(Integer id, String title, String content, Date timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }
}
