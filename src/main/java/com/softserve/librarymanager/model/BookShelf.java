package com.softserve.librarymanager.model;

public class BookShelf extends AbstractEntity {
    private Book book;
    private User user;

    private String bookShelfName;

    public BookShelf() { }

    public String getBookShelfName() {
        return bookShelfName;
    }

    public void setBookShelfName(String bookShelfName) {
        this.bookShelfName = bookShelfName;
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

    @Override
    public String toString() {
        return "BookShelf{" + "book=" + book + ", user=" + user + ", bookShelfName='" + bookShelfName + '\'' + "} "
               + super.toString();
    }
}
