package com.ilyasidorov.librarymanager.service;

import com.ilyasidorov.librarymanager.domain.Role;
import com.ilyasidorov.librarymanager.domain.User;
import com.ilyasidorov.librarymanager.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MailSender mailSender;

    public UserServiceImpl(UserRepository userRepository, MailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        saveUser(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format("Hello %s! \n" +
                            "Welcome to the Library-manager. Please visit: http://localhost:8080/activate/%s",
                    user.getUsername(), user.getActivationCode());
            mailSender.send(user.getEmail(), "Activation Code", message);
        }
        return true;
    }

    @Override
    public User findUserByActivationCode(String code) {
        return userRepository.findByActivationCode(code);
    }

    @Override
    public boolean activateUser(String code) {
        User user = findUserByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        saveUser(user);

        return true;
    }
}
