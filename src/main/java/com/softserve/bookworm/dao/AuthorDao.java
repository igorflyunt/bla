package com.softserve.bookworm.dao;

import com.softserve.bookworm.model.Author;

import java.util.List;

public interface AuthorDao extends Dao<Author> {
    List<Author> findAuthorsByBookId(int bookId);
}
