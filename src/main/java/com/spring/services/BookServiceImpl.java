package com.spring.services;

import com.spring.entities.Book;
import com.spring.entities.IssueBook;
import com.spring.repositories.BookRepository;
import com.spring.repositories.IssueBookRepository;
import com.spring.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepo;

    @Override
    public void addBook(Book b) {
        if(null !=b)
            b.setAvailable(true);
        bookRepo.save(b);
    }
    @Override
    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> getAllBookAvailable() {
        return bookRepo.findAllAvailable();
    }

    //to find a book by id
    @Override
    public Book findById(int id)
    {
        return bookRepo.findById(id).get();
    }

    //delete book by id
    @Override
    public void deletebyID(int id)
    {
        bookRepo.deleteById(id);
    }

    //Update data in table
    @Override
    public Book update(Book b) {
        return bookRepo.save(b);
    }

}
