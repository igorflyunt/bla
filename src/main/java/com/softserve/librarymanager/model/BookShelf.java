package com.softserve.librarymanager.model;

public class BookShelf extends AbstractEntity {
    public enum BookShelves {
        READ ("read"),
        CURRENTLY_READING ("currently-reading"),
        TO_READ ("to-read");

        private String bookShelfName;

        BookShelves(String bookShelfName) {
            this.bookShelfName = bookShelfName;
        }
    }

    private BookShelves status;

    public BookShelf() { }

    public String getBookShelfName() {
        return status.bookShelfName;
    }

    public void setStatus(BookShelves status) {
        this.status = status;
    }
}
