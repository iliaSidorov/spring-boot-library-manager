package com.ilyasidorov.librarymanager.service;

import com.ilyasidorov.librarymanager.domain.User;

public interface UserService {

    User findUserByUsername(String username);
    void saveUser(User user);
}
