package com.example.demo.UsersRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.user.User;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);


}