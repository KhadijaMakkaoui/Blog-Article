package com.blog.acrticle.repositories;

import com.blog.acrticle.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUserName(String userName);
    List<User> findAllByOrderByRegDateTimeDesc();

}
