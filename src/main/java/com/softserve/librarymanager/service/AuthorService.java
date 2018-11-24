package com.softserve.librarymanager.service;

import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.dao.impl.AuthorDaoImpl;
import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.dao.impl.GenreDaoImpl;
import com.softserve.librarymanager.model.Author;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.model.Genre;

import java.util.List;
import java.util.Optional;

public class AuthorService {
    private AuthorDao authorDao = new AuthorDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    private GenreDao genreDao = new GenreDaoImpl();

    public Optional<Author> findAuthorById(int authorId) {
        return authorDao.findById(authorId).map(this::getAuthorFullData);
    }

    private Author getAuthorFullData(Author author) {
        int authorId = author.getId();
        List<Genre> genres = genreDao.findGenresByAuthorId(authorId);
        List<Book> books = bookDao.findAllBooksByAuthorId(authorId);
        author.setGenres(genres);
        author.setBooks(books);
        return author;
    }
}
