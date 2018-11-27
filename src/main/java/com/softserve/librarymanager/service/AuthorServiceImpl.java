package com.softserve.librarymanager.service;

import com.google.inject.Inject;
import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.model.Author;
import com.softserve.librarymanager.model.Book;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl extends AbstractService<Author, AuthorDao> implements AuthorService {
    @Inject
    private BookService bookService;

    @Inject
    private GenreDao    genreDao;

    @Inject
    public AuthorServiceImpl(AuthorDao dao) {
        super(dao);
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = getDao().findAll();
        authors.forEach(this::initAuthorEagerly);
        return authors;
    }

    @Override
    public Optional<Author> findById(int authorId) {
        return getDao().findById(authorId).map(this::initAuthorEagerly);
    }

    @Override
    public List<Author> findAuthorsByBookId(int bookId) {
        return getDao().findAuthorsByBookId(bookId);
    }

    @Override
    public void delete(Author entity) {
        int authorId = entity.getId();
        List<Book> books = bookService.findBooksByAuthorId(authorId);
        books.forEach(bookService::delete);
        getDao().delete(entity);
    }

    private Author initAuthorEagerly(Author author) {
        int authorId = author.getId();
        author.setGenres(genreDao.findGenresByAuthorId(authorId));
        author.setBooks(bookService.findBooksByAuthorId(authorId));
        return author;
    }
}
