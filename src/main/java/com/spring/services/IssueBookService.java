package com.spring.services;

import com.spring.entities.Book;
import com.spring.entities.IssueBook;
import com.spring.entities.User;
import com.spring.repositories.BookRepository;
import com.spring.repositories.IssueBookRepository;
import com.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueBookService {

    @Autowired
    private IssueBookRepository issueBookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public void saveIssuedBook(IssueBook issueBook)
    {
        User user=issueBook.getUser();
        List<Book> bookList=new ArrayList<>();
        bookList.add(issueBook.getBook());
        user.getBooks().addAll(bookList);
        userRepository.save(user);

        Book book = issueBook.getBook();
        book.setAvailable(false);
        bookRepository.save(book);

        issueBookRepository.save(issueBook);
    }
}
