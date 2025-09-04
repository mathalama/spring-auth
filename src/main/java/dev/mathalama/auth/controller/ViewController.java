package dev.mathalama.auth.controller;

import dev.mathalama.auth.dto.RegistrationRequest;
import dev.mathalama.auth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    private final UserService userService;

    public ViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("form", new RegistrationRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute("form") RegistrationRequest form) {
        userService.register(form);
        return "redirect:/login";
    }
}


