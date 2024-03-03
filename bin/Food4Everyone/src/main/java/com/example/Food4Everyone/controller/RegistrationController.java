package com.example.Food4Everyone.controller;

import com.example.Food4Everyone.Dto.UserRegistration;
import com.example.Food4Everyone.Service.UserInfoService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class RegistrationController 
{

    private UserInfoService userInfoService;

    public RegistrationController(UserInfoService userInfoService) 
    {
        super();
        this.userInfoService = userInfoService;
    }

    @ModelAttribute("user")
    public UserRegistration userRegistrationDto() 
    {
        return new UserRegistration();
    }

    @GetMapping
    public String showRegistrationForm() 
    {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistration registration) 
    {
        userInfoService.save(registration);
        return "redirect:/registration?success";
    }
}
