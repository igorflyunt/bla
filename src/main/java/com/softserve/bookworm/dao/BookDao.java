package com.softserve.bookworm.dao;

import com.softserve.bookworm.model.Book;

import java.util.List;

public interface BookDao extends Dao<Book> {

    List<Book> findAllBooksByAuthorId(int authorId);

    List<Book> findTenLatestBooks();

    void mapBookToAuthor(int bookId, int authorId);
}
