package com.softserve.librarymanager.service;

import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.dao.impl.AuthorDaoImpl;
import com.softserve.librarymanager.dao.impl.GenreDaoImpl;
import com.softserve.librarymanager.model.Author;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl extends AbstractService<Author, AuthorDaoImpl> implements AuthorService {
    private BookServiceImpl bookService = new BookServiceImpl();
    private AuthorDao       authorDao   = new AuthorDaoImpl();
    private GenreDao        genreDao    = new GenreDaoImpl();

    public AuthorServiceImpl() {
        super(new AuthorDaoImpl());
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public Optional<Author> findById(int authorId) {
        return authorDao.findById(authorId).map(this::initAuthorEagerly);
    }

    @Override
    public List<Author> findAuthorsByBookId(int bookId) {
        return getDao().findAuthorsByBookId(bookId);
    }

    private Author initAuthorEagerly(Author author) {
        int authorId = author.getId();
        author.setGenres(genreDao.findGenresByAuthorId(authorId));
        author.setBooks(bookService.findAllBooksByAuthorId(authorId));
        return author;
    }

}
