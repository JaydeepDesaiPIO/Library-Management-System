package com.spring.dto;

public class UserRegisterationDto {
    private String email;
    private String username;
    private String password;
    private Long contact;
    private String address;

    public UserRegisterationDto() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserRegisterationDto(String email, String username, String password, Long contact, String address) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.address = address;
    }
}
