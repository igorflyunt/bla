package com.softserve.librarymanager.model;

import java.util.List;

public class User extends Person {

    private List<Book> books;
    private static final UserRole DEFAULT_ROLE = UserRole.USER;

    private UserRole role = DEFAULT_ROLE;

    private User() { }

    public List<Book> getBooks() {
        return books;
    }

    public UserRole getRole() {
        return role;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "books=" + books +
                ", role=" + role +
                "} " + super.toString();
    }
}
