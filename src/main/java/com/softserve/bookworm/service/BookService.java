package com.softserve.bookworm.service;

import com.softserve.bookworm.model.Book;

import java.util.List;

public interface BookService extends Service<Book> {
    List<Book> findBooksByAuthorId(int authorId);

    List<Book> findTenLatestBooks();

    void addBookToAuthor(int bookId, int authorId);
}
