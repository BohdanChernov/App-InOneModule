package com.shop.controllers;

import com.shop.forms.MemberForm;
import com.shop.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String registrationPageGet() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPagePost(MemberForm memberForm) {
        registrationService.registration(memberForm);
        return "redirect:/login";
    }
}
