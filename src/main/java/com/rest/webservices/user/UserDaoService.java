package com.rest.webservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component // To be managed by Spring
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    private static List<Post> posts = new ArrayList<>();
    private int postCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2,"Eve", new Date()));
        users.add(new User(3,"Abel", new Date()));
    }

    static {
        posts.add(new Post(1,"Kubernetes in Action","This is a great book", new Date()));
        posts.add(new Post(2,"Docker in Action","A must read ", new Date()));
        posts.add(new Post(3,"Spring Microservices","A great book for Spring MVC ", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User saveUser(User user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user:users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Code for Posts
    public List<Post> findAllPosts() {
        return posts;
    }

    public Post addPost(Post post) {
        if (post.getId() == null) {
            post.setId(++postCount);
        }
        posts.add(post);
        return post;
    }

    public Post retreiveSinglePost(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                return post;
            }

        }
        return null;
    }

    public User deleteUserById(int id) {
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getId() == id ) {
                userIterator.remove();
                return user;
            }
        }

        return null;
    }

    public Post deleteSinglePostById(int id) {
        Iterator<Post> iterator = posts.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            if (post.getId() == id) {
                iterator.remove();
                return post;
            }
        }
        return null;
    }
}
