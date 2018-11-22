package com.softserve.librarymanager.dao;

import com.softserve.librarymanager.model.Book;

import java.util.List;

public interface BookDao {
    void saveOrUpdate(Book book);

    void deleteById(int id);

    Book findById(int id);

    List<Book> findAll();

    List<Book> findAllBooksByAuthorId(int bookId);
}
