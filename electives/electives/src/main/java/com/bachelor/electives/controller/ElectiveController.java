package com.bachelor.electives.controller;

import com.bachelor.electives.entity.ElectiveEntity;
import com.bachelor.electives.exception.ElectiveAlreadyExistException;
import com.bachelor.electives.exception.ElectiveNotFoundException;
import com.bachelor.electives.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/electives")
public class ElectiveController {

    @Autowired
    private ElectiveService electiveService;

    @GetMapping("/{id}")
    public String getCourse(@PathVariable(value = "id") long id, Model model) {
        Iterable<ElectiveEntity> electives = null;
        try {
            electives = electiveService.findAllByTopicId(id);
        } catch (ElectiveNotFoundException e) {
            return e.getMessage();
        }
        model.addAttribute("electives", electives);
        return "electives";
    }
    @PostMapping
    public ResponseEntity addElective(@RequestBody ElectiveEntity elective) {
        try {
            electiveService.createElective(elective);
            return ResponseEntity.ok("Elective created successfully");
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
}
