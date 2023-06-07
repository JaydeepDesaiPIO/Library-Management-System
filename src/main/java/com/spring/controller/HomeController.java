package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String base()
    {
        return "home";
    }

    @RequestMapping("/signup")
    public String sign(Model model)
    {
        model.addAttribute("title","Registration form");
        return "signup";
    }
}
