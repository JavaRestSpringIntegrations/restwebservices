package com.rest.webservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PostRepository extends JpaRepository<NewPost,Integer> {
}
