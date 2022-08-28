package com.vinit.feedback.dao;

import com.vinit.feedback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findUserByFirstName(String name);

    Optional<User> findUserByEmail(String email);
}
