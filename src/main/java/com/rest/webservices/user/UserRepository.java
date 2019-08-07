package com.rest.webservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*  JpaRepository<User, Integer>
    First param: entity to be managed
    Second param: the data type of the primary key
*/

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
