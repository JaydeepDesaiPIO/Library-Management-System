package com.spring.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
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

    private Date issueDate;

    private Date retureDate;

}
