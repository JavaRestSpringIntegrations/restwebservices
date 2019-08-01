package com.rest.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id-"+ id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = service.saveUser(user);

        // Return the current request URL
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") //appending id to the URL
                .buildAndExpand(savedUser.getId()) // expand the URI
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // How to return the created status - Use Response.Entity

}
