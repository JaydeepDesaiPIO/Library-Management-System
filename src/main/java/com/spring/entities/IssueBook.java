package com.spring.entities;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class IssueBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int borrowId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="book_id", referencedColumnName="book_id"),
            @JoinColumn(name="book_name", referencedColumnName="name")
    })
    @NotNull
    private Book book;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date retureDate;

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getRetureDate() {
        return retureDate;
    }

    public void setRetureDate(Date retureDate) {
        this.retureDate = retureDate;
    }

}
