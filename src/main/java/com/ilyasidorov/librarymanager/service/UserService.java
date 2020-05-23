package com.ilyasidorov.librarymanager.service;

import com.ilyasidorov.librarymanager.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findUserByUsername(String username);

    void saveUser(User user);

    List<User> findAllUsers();

    boolean addUser(User user);

    boolean activateUser(String code);

    User findUserByActivationCode(String code);
}
