package com.softserve.librarymanager.model;

import java.util.Date;
import java.util.List;

public class Book extends AbstractEntity {
    private String bookName;
    private String description;
    private Date firstPublished;
    private List<Genre> genres;

    public Book() { }

    public String getName() {
        return bookName;
    }

    public String getDescription() {
        return description;
    }

    public Date getFirstPublished() {
        return firstPublished;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFirstPublished(Date firstPublished) {
        this.firstPublished = firstPublished;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", description='" + description + '\'' +
                ", firstPublished=" + firstPublished +
                ", genres=" + genres +
                "} " + super.toString();
    }
}
