package com.softserve.bookworm.service;

import com.softserve.bookworm.model.Author;

import java.util.List;

public interface AuthorService extends Service<Author> {
    List<Author> findAuthorsByBookId(int bookId);
}
