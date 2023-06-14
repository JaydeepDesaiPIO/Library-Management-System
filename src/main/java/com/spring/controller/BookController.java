package com.spring.controller;

import com.spring.entities.Book;
import com.spring.entities.IssueBook;
import com.spring.entities.User;
import com.spring.repositories.IssueBookRepository;
import com.spring.repositories.UserRepository;
import com.spring.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IssueBookRepository issueBookRepository;

    @ModelAttribute("users")
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/")
    public String base(Model model, Principal principal)
    {
        String user=principal.getName();
        User user1=userRepository.getUserByName(user);
        model.addAttribute("user",user1);
        return "admin/home.html";
    }
    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public String bookList(Model model)
    {
            model.addAttribute("books", bookService.getAllBook());
            return "admin/books.html";
    }

    @GetMapping("/books/new")
    public String createBook(Model model)
    {
        Book book=new Book();
        model.addAttribute("book",book);
        return "admin/create_book.html";
    }

    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book)
    {
        bookService.addBook(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "admin/edit_book";
    }

    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable int id,
            @ModelAttribute("book") Book book,
            Model model)
    {
        // get book from database by id
        Book b = bookService.findById(id);
        b.setName(book.getName());
        b.setAuthor(book.getAuthor());
        b.setBookDiscription(book.getBookDiscription());

        // save updated book
        bookService.update(b);
        return "redirect:/admin/books";
    }

    @GetMapping("/books/{id}")
    public String deleteBook(@PathVariable int id)
    {
        bookService.deletebyID(id);
        return "redirect:/admin/books";
    }

    @GetMapping("/issuebook/{id}")
    public String issueBookToUser(@PathVariable int id,Model model)
    {
        Book book=bookService.findById(id);
        IssueBook issueBook=new IssueBook();
        issueBook.setBook(book);
        model.addAttribute("issueBook",issueBook);
        return "admin/issue_Book";
    }

    @PostMapping("/issueBooks")
    public String issue(@ModelAttribute ("issueBook") IssueBook issueBook)
    {
        User user=issueBook.getUser();
        user.setBooks(List.of(issueBook.getBook()));
        issueBookRepository.save(issueBook);
        return "redirect:/admin/issuedBooks";
    }

    @RequestMapping(value = "/issuedBooks",method = RequestMethod.GET)
    public String issuedBooks(Model model)
    {
        model.addAttribute("issuedBooks",issueBookRepository.findAll());
        return "admin/issued_bookList";
    }



}
