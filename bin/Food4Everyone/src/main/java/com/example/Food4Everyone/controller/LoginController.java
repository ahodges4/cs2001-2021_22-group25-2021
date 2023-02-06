package com.example.Food4Everyone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{

    @GetMapping("/login")
    public String login() 
    {
        return "login";
    }

    @GetMapping("/")
    public String Redirect() 
    {
        return "ControlPage";
    }
    
    @GetMapping("/faq")
    public String faq()
    {
    	return "faq";
    }
    
    @GetMapping("/home")
    public String home()
    {
    	return "home";
    }
    
    @GetMapping("/forgot")
    public String forgot()
    {
    	return "forgot";
    }
    
    @GetMapping("/map")
    public String map()
    {
    	return "map";
    }
    

    @GetMapping("/PrivacyPolicy")
    public String privacyPolicy()
    {
        return "Privacypolicy";
    }

    @GetMapping("/ControlPage")
    public String ControlPage()
    {
        return "ControlPage";
    }

    @GetMapping("/NewsPage")
    public String NewsPage()
    {
        return "NewsPage";
    }
    @GetMapping("/newsPage")
    public String newsPage()
    {
        return "news";
    }

    @GetMapping("/changecredential")
    public String changecredential()
    {
        return "changecredential";
    }
}
