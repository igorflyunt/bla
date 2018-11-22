package com.softserve.librarymanager.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Author extends Person {

    private Date birthDate;
    private List<Book> books = new ArrayList<>();

    public Author() { }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void addBooks(Book book) {
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "birthDate=" + birthDate +
                ", books=" + books +
                '}' + super.toString();
    }
}
