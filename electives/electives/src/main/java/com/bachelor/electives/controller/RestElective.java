package com.bachelor.electives.controller;

import com.bachelor.electives.entity.ElectiveEntity;
import com.bachelor.electives.exception.ElectiveAlreadyExistException;
import com.bachelor.electives.service.ElectiveService;
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
@RequestMapping("/test")
public class RestElective {

    @Autowired
    private ElectiveService electiveService;

    @PostMapping
    public ResponseEntity addElective(@RequestBody ElectiveEntity elective, @RequestParam Long topicId) {
        try {
            return ResponseEntity.ok(electiveService.createElective(elective, topicId));
        } catch (ElectiveAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteElective(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(electiveService.deleteElective(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping
    public ResponseEntity getAllElectives() {
        try {
            return ResponseEntity.ok(electiveService.getElective());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
