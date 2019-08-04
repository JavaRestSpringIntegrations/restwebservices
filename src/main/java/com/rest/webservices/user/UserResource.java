package com.rest.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public Resource<User> getOneUser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id-"+ id);

        // HATEOS
        Resource<User> resource = new Resource<User>(user);

        //enable to create links from methods
        ControllerLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).getAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.saveUser(user);

        // Return the current request URL
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") //appending id to the URL
                .buildAndExpand(savedUser.getId()) // expand the URI
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // How to return the created status - Use Response.Entity

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return service.findAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable int id) {
        Post singlePost = service.retreiveSinglePost(id);
        if (singlePost == null)
            throw new PostNotFoundException("Post-ID: "+id);
        return singlePost;
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return service.addPost(post);
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteUserById(id);
        if (user == null)
            throw new UserNotFoundException("Not-Found: "+id);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
        Post post = service.deleteSinglePostById(id);
        if (post == null)
            //throw new PostNotFoundException("Post-Not-Found: "+id);
            return new ResponseEntity<>("No post found with: "+id, HttpStatus.NOT_FOUND);

//             return empty content
//            ResponseEntity.noContent();
        return null;
    }

}
