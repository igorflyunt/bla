package com.softserve.librarymanager.service;

import com.softserve.librarymanager.model.Book;

import java.util.List;

public interface BookService extends Service<Book> {
    List<Book> findBooksByAuthorId(int authorId);

    List<Book> findTenLatestBooks();

    void mapBookToAuthor(int bookId, int authorId);
}
