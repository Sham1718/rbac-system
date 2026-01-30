package com.rbac_Backend.service;


import com.rbac_Backend.dto.RegisterRequest;
import com.rbac_Backend.entity.Role;
import com.rbac_Backend.entity.User;
import com.rbac_Backend.repository.RoleRepository;
import com.rbac_Backend.repository.UserRepository;
import com.rbac_Backend.config.PasswordConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service

public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordConfig passwordConfig, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

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
}
