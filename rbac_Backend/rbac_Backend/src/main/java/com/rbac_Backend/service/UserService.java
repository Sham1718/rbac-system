package com.rbac_Backend.service;


import com.rbac_Backend.dto.AuthResponse;
import com.rbac_Backend.dto.LoginRequest;
import com.rbac_Backend.dto.RegisterRequest;
import com.rbac_Backend.entity.Role;
import com.rbac_Backend.entity.User;
import com.rbac_Backend.repository.RoleRepository;
import com.rbac_Backend.repository.UserRepository;
import com.rbac_Backend.config.PasswordConfig;
import com.rbac_Backend.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service

public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordConfig passwordConfig, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(RegisterRequest request){
        Role role=roleRepository.findByName("USER")
                .orElseThrow(()->new RuntimeException("user role not found"));
        User user=User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(role))
                .build();

        userRepository.save(user);

    }

    public AuthResponse login(LoginRequest request){
        User user =userRepository.findByUsername(request.getUsername())
                .orElseThrow(()->new RuntimeException("User Not Found..!"));

        if (!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid Credentials..!");
        }
        String response= jwtService.generateToken(user.getUsername());
        AuthResponse authResponse =new AuthResponse();
        authResponse.setToken(response);
        return authResponse;
    }

    public List<User> getAllUsers() {
       return userRepository.findAll();
    }
//manual admin creation
//    public void createAdmin(String username, String email, String rawPassword) {
//        if (userRepository.existsByUsername(username)) return;
//
//        Role adminRole = roleRepository.findByName("ADMIN")
//                .orElseThrow(() -> new RuntimeException("ADMIN role not found"));
//
//        User user = new User();
//        user.setUsername(username);
//        user.setEmail(email);
//        user.setPassword(passwordEncoder.encode(rawPassword));
//        user.setRoles(Set.of(adminRole));
//
//        userRepository.save(user);
//    }
}
