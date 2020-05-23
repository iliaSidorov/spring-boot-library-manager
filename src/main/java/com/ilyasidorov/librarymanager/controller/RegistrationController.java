package com.ilyasidorov.librarymanager.controller;

import com.ilyasidorov.librarymanager.domain.User;
import com.ilyasidorov.librarymanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String getAddingUser(User user, Model model) {
        User userFromDb = userService.findUserByUsername(user.getUsername());
        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
