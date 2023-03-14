package com.bachelor.electives.controller;

import com.bachelor.electives.entity.TopicEntity;
import com.bachelor.electives.exception.TopicNotFoundException;
import com.bachelor.electives.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public String home(Model model) {
        try {
            Iterable<TopicEntity> topics = topicService.findAllElectives();
            model.addAttribute("topics", topics);
            return "home";
        } catch (TopicNotFoundException ex) {
            return ex.getMessage();
        }
    }

    @GetMapping("/sign")
    public String sign() {
        return "sign";
    }

    @GetMapping("/contacts")
    public String contacts() {
        try {
            return "contacts";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @GetMapping("/registration")
    public String registration() {
        try {
            return "registration";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @GetMapping("/cabinet")
    public String cabinet() {
        return "cabinet";
    }
}
