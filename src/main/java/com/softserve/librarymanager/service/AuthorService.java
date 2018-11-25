package com.softserve.librarymanager.service;

import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.dao.impl.AuthorDaoImpl;
import com.softserve.librarymanager.dao.impl.GenreDaoImpl;
import com.softserve.librarymanager.model.Author;

import java.util.Optional;

public class AuthorService {
    private BookService bookService = new BookService();
    private AuthorDao authorDao = new AuthorDaoImpl();

    private GenreDao genreDao = new GenreDaoImpl();

    public Optional<Author> findAuthorById(int authorId) {
        return authorDao.findById(authorId).map(this::initAuthorEagerly);
    }

    private Author initAuthorEagerly(Author author) {
        int authorId = author.getId();
        author.setGenres(genreDao.findGenresByAuthorId(authorId));
        author.setBooks(bookService.findAllBooksByAuthorId(authorId));
        return author;
    }
}
