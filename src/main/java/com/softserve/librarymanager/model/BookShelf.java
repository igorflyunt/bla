package com.softserve.librarymanager.model;

public class BookShelf extends AbstractEntity {
    public enum BookShelfStatus {
        READ,
        WANT_TO_READ,
        CURRENTLY_READING,
        TO_READ
    }

    private BookShelfStatus status;

    private BookShelf() { }

    public BookShelfStatus getStatus() {
        return status;
    }

    public void setStatus(BookShelfStatus status) {
        this.status = status;
    }
}
