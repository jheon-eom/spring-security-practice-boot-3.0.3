package com.security.practice.controller;

import com.security.practice.config.AdminAuthorize;
import com.security.practice.config.UserAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("role", user.getAuthorities());
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/admin")
    @AdminAuthorize
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/user")
    @UserAuthorize
    public String userPage() {
        return "user";
    }
}
