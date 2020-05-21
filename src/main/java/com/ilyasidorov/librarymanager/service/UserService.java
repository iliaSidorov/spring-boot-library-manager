package com.ilyasidorov.librarymanager.service;

import com.ilyasidorov.librarymanager.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findUserByUsername(String username);
    void saveUser(User user);
}
