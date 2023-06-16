package com.spring.controller;

import com.spring.entities.Book;
import com.spring.entities.IssueBook;
import com.spring.entities.User;
import com.spring.repositories.UserRepository;
import com.spring.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String base(Model model, Principal principal)
    {
        String user=principal.getName();
        User user1=userRepository.getUserByName(user);
        model.addAttribute("user",user1);
        return "normal/home.html";
    }

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public String bookList(Model model)
    {
        model.addAttribute("books", bookService.getAllBook());
        return "normal/book_list.html";
    }

    @RequestMapping(value = "/myBooks", method = RequestMethod.GET)
    public String myBooks(Model model,Principal principal)
    {
        String name=principal.getName();
        User user=userRepository.getUserByName(name);
        List<Book> userBook= user.getBooks();
        model.addAttribute("userBooks",userBook);
        return "normal/my_books.html";
    }


}
