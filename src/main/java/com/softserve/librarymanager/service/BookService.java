package com.softserve.librarymanager.service;

import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.dao.impl.AuthorDaoImpl;
import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.dao.impl.GenreDaoImpl;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.model.Genre;

import java.util.List;
import java.util.Optional;

public class BookService {
    private BookDao bookDao = new BookDaoImpl();
    private AuthorDao authorDao = new AuthorDaoImpl();
    private GenreDao genreDao =  new GenreDaoImpl();

    public List<Book> findAllBooks() {
        List<Book> books = bookDao.findAll();
        setBookAuthors(books);
        return books;
    }

    public List<Book> findTenLatestBooks() {
        List<Book> books = bookDao.findTenLatestBooks();
        setBookAuthors(books);
        return books;
    }

    public Optional<Book> findBookById(int bookId) {
        final List<Genre> bookGenres = genreDao.findGenresByBookId(bookId);
        return bookDao.findById(bookId).map(book -> {
            book.setGenres(bookGenres);
            book.setAuthors(authorDao.findAllAuthorsByBookId(book.getId()));
            book.setGenres(genreDao.findGenresByBookId(book.getId()));
            return book;
        });
    }

    private void setBookAuthors(List<Book> books) {
        for (Book book : books) {
            book.setAuthors(authorDao.findAllAuthorsByBookId(book.getId()));
        }
    }
}
