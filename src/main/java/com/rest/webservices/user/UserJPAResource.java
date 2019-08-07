package com.rest.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserJPAResource {

    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Resource<User> getOneUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
            throw new UserNotFoundException("id-"+ id);

        // HATEOS - creates hyperlink
        Resource<User> resource = new Resource<User>(user.get());

        //enable to create links from methods
        ControllerLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).getAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        // Return the current request URL
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") //appending id to the URL
                .buildAndExpand(savedUser.getId()) // expand the URI
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // How to return the created status - Use Response.Entity

    @GetMapping("/jpa/posts")
    public List<Post> getAllPosts() {
        return service.findAllPosts();
    }

    @GetMapping("/jpa/posts/{id}")
    public Post getSinglePost(@PathVariable int id) {
        Post singlePost = service.retreiveSinglePost(id);
        if (singlePost == null)
            throw new PostNotFoundException("Post-ID: "+id);
        return singlePost;
    }

    @PostMapping("/jpa/posts")
    public Post createPost(@RequestBody Post post) {
        return service.addPost(post);
    }


    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @DeleteMapping("/jpa/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
        Post post = service.deleteSinglePostById(id);
        if (post == null)
            //throw new PostNotFoundException("Post-Not-Found: "+id);
            return new ResponseEntity<>("No post found with: "+id, HttpStatus.NOT_FOUND);

//             return empty content
//            ResponseEntity.noContent();
        return null;
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<NewPost> getUserPosts(@PathVariable int id) {

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent())
            throw new UserNotFoundException("id-"+ id);
        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id,
                                             @RequestBody NewPost post) {

        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent())
            throw new UserNotFoundException("id-"+ id);

        User user = userOptional.get();
        post.setUser(user);

        postRepository.save(post);

        // Return the current request URL
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") //appending id to the URL
                .buildAndExpand(post.getId()) // expand the URI
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
