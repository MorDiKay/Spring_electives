package com.bachelor.electives.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity getUser(){
        try {
            return ResponseEntity.ok("Server is working");
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }
}
