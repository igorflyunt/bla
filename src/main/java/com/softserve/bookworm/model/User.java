package com.softserve.bookworm.model;

import java.util.List;

public class User extends Person {
    private static final UserRole DEFAULT_ROLE = UserRole.USER;

    private String username;
    private String password;

    private List<Book> books;

    private UserRole role = DEFAULT_ROLE;

    public User() { }

    public List<Book> getBooks() {
        return books;
    }

    public String getRole() {
        return role.name();
    }

    public void setRole(UserRole role) {
        this.role = role;
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

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "books=" + books +
                ", role=" + role +
                "} " + super.toString();
    }
}
