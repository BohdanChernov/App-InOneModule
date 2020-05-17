package com.shop.controllers;

import com.shop.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String name, String email, String body) {
        String request = "Request from " + name + ", e-mail to response: " + email;
        emailService.sendMessage("appfortestsemail@gmail.com", request, body);
        return "feedback";
    }
}
