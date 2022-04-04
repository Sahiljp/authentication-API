package com.authentication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthRestController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/auth/login/{userName}")
    public ResponseEntity<String> login(@PathVariable String userName) {
        String token = jwtUtil.generateToken(userName);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@RequestBody String userName) {
        // Persist user to some persistent storage
        System.out.println("Info saved...");

        return new ResponseEntity<String>("Registered", HttpStatus.OK);
    }

}
