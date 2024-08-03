package com.contacts.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/contacts")
public class Controller {
    @GetMapping("/main")
    public String prolapse() {
        return "Welcome";
    }
}
