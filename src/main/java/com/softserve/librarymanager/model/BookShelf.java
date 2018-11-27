package com.softserve.librarymanager.model;

public class BookShelf extends AbstractEntity {
    public enum BookShelves {
        READ ("Read"),
        WANT_TO_READ ("Want to read"),
        CURRENTLY_READING ("Currently reading"),
        TO_READ ("To-read");

        private String bookShelfName;

        BookShelves(String bookShelfName) {
            this.bookShelfName = bookShelfName;
        }
    }

    private BookShelves status;

    private BookShelf() { }

    public String getBookShelfName() {
        return status.bookShelfName;
    }

    public void setStatus(BookShelves status) {
        this.status = status;
    }
}
