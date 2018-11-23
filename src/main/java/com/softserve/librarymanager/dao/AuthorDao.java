package com.softserve.librarymanager.dao;

import com.softserve.librarymanager.model.Author;
import com.softserve.librarymanager.model.Book;

import java.util.List;

public interface AuthorDao extends Dao<Author> {
    List<Book> findAllAuthorsByBookId(int bookId);
}
