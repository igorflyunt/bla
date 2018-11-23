package com.softserve.librarymanager.dao;

import com.softserve.librarymanager.model.Author;

import java.util.List;

public interface AuthorDao extends Dao<Author> {
    List<Author> findAllAuthorsByBookId(int bookId);
}
