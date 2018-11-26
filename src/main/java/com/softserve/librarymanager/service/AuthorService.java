package com.softserve.librarymanager.service;

import com.softserve.librarymanager.model.Author;

import java.util.List;

public interface AuthorService extends Service<Author> {
    List<Author> findAuthorsByBookId(int bookId);
}
