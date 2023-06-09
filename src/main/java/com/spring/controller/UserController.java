package com.spring.controller;

import com.spring.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String base()
    {
        return "normal/home.html";
    }

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public String bookList(Model model)
    {
        model.addAttribute("books", bookService.getAllBook());
        return "normal/book_list.html";
    }
}
