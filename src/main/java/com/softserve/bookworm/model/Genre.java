package com.softserve.bookworm.model;

import java.util.List;

public class Genre extends AbstractEntity {
    private String genreName;
    private List<Author> authors;
    private List<Book> books;

    public Genre() { }

    public String getGenreName() {
        return genreName;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreName='" + genreName + '\'' +
                ", authors=" + authors +
                ", books=" + books +
                "} " + super.toString();
    }
}
