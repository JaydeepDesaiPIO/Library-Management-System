package com.spring.services.interfaces;

import com.spring.entities.Book;
import com.spring.entities.IssueBook;

import java.util.List;

public interface BookService {

    public void addBook(Book b);

    public List<Book> getAllBook();

    public List<Book> getAllBookAvailable();

    //to find a book by id
    Book findById(int id);

    public void deletebyID(int id);

    //Update data in table
    Book update(Book b);

}
