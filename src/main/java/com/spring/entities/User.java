package com.spring.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String username;
    private String password;
    private Long contact;
    private String address;
    private String role;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> books=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User() {
    }

    public User(int id, String email, String username, String password, Long contact, String address, String role, List<Book> books) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.address = address;
        this.role = role;
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", books=" + books +
                '}';
    }
}
