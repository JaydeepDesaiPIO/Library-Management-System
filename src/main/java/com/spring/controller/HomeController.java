package com.spring.controller;

import com.spring.dto.UserRegisterationDto;
import com.spring.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String base()
    {
        return "home";
    }

    @GetMapping("/signup")
    public String sign(Model model)
    {
        UserRegisterationDto registerationDto=new UserRegisterationDto();
        model.addAttribute("user",registerationDto);
        model.addAttribute("title","Registration form");
        return "signup.html";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user")UserRegisterationDto registerationDto)
    {
        userService.addUser(registerationDto);
        return "redirect:/home/signup";
        //?success
    }
}
