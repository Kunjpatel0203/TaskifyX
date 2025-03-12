package com.example.taskifyX.controller;

import com.example.taskifyX.config.JwtProvider;
import com.example.taskifyX.model.User;
import com.example.taskifyX.repository.UserRepository;
import com.example.taskifyX.service.CustomeUserServiceImplementation;
import com.example.taskifyX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomeUserServiceImplementation customUserDetails;

    @PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(
            @RequestBody User user) throws Exception {
        User isUserExists = userRepository.findByEmail(user.getEmail());

        if (isUserExists != null) {
            throw new Exception("Email already exists");
        }

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setFullName(user.getFullName());

        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = JwtProvider.generateToken(authentication);

        return new ResponseEntity<>(userRepository.save(newUser), HttpStatus.CREATED);
    }
}
