package com.bachelor.electives.controller;

import com.bachelor.electives.entity.UserEntity;
import com.bachelor.electives.exception.UserAlreadyExistException;
import com.bachelor.electives.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserEntity user, @RequestParam Long roleId) {
        try {
            return ResponseEntity.ok(userService.createUser(user, roleId));
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getUser());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
