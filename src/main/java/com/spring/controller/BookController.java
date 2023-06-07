package com.spring.controller;

import com.spring.entities.Book;
import com.spring.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class BookController {
    @Autowired
    private BookService bookService;

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



}
