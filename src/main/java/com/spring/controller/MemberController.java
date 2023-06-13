package com.spring.controller;

import com.spring.entities.Book;
import com.spring.entities.User;
import com.spring.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class MemberController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model)
    {
        model.addAttribute("users",userService.getAllUsers());
        return "admin/users.html";
    }

    @GetMapping("/users/edit/{id}")
    public String editBook(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "admin/edit_user";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    public String updateBook(@PathVariable int id,
                             @ModelAttribute("user") User user,
                             Model model)
    {
        // save updated book
        userService.update(user,id);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/{id}")
    public String deleteBook(@PathVariable int id)
    {
        userService.deleteByID(id);
        return "redirect:/admin/users";
    }

}
