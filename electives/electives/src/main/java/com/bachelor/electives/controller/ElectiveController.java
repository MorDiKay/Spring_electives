package com.bachelor.electives.controller;

import com.bachelor.electives.entity.ElectiveEntity;
import com.bachelor.electives.exception.ElectiveNotFoundException;
import com.bachelor.electives.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
