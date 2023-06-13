package com.spring.controller;

import com.spring.entities.User;
import com.spring.helper.Message;
import com.spring.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
        User user=new User();
        model.addAttribute("user",user);
        model.addAttribute("title","Registration form");
        return "signup.html";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user")User user, Model model, HttpSession session) {
        try {
            userService.addUser(user);
            model.addAttribute("user",new User());
            session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
            return "redirect:/home/signup";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message", new Message("Something went Wrong !!", "alert-danger"));
            return "redirect:/home/signup";
        }
    }
}
