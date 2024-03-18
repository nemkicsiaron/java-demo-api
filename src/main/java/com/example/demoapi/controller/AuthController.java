package com.example.demoapi.controller;

import com.example.demoapi.payload.LoginDTO;
import com.example.demoapi.payload.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestParam LoginDTO data) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                data.getUsernameOrEmail(), data.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("Successful sign-in for user: " + authentication.getPrincipal().toString(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO data) {
        //String
        return new ResponseEntity<>("Successful registration for user: " , HttpStatus.OK);
    }
}
