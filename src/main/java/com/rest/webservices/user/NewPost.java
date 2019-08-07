package com.rest.webservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// An user entity can do many posts
// post is tied to one user

@Data
@Entity
public class NewPost {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    @Getter(AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
