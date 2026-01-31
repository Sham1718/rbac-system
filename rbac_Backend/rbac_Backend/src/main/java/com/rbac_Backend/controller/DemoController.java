package com.rbac_Backend.controller;

import com.rbac_Backend.entity.User;
import com.rbac_Backend.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {
    private final UserService userService;

    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/read")
    @PreAuthorize("hasAuthority('USER_READ')")
    public String read(){
        return "Read allowed";
    }

    @PostMapping("/write")
    @PreAuthorize("hasAuthority('USER_WRITE')")
    public String write(){
        return "write allowed";
    }

    @PostMapping("/assign")
    @PreAuthorize("hasAuthority('ROLE_ASSIGN')")
    public String assign(){
        return "Role Assign";
    }

    @PreAuthorize("hasAuthority('USER_READ')")
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }



}
