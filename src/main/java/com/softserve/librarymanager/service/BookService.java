package com.softserve.librarymanager.service;

import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.dao.impl.AuthorDaoImpl;
import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.dao.impl.GenreDaoImpl;
import com.softserve.librarymanager.model.Book;

import java.util.List;
import java.util.Optional;

public class BookService {
    private BookDao bookDao = new BookDaoImpl();
    private AuthorDao authorDao = new AuthorDaoImpl();
    private GenreDao genreDao =  new GenreDaoImpl();

    public List<Book> findAllBooks() {
        List<Book> books = bookDao.findAll();
        books.forEach(this::initBookEagerly);
        return books;
    }

    public List<Book> findTenLatestBooks() {
        List<Book> books = bookDao.findTenLatestBooks();
        books.forEach(this::initBookEagerly);
        return books;
    }

    public Optional<Book> findBookById(int bookId) {
        return bookDao.findById(bookId).map(this::initBookEagerly);
    }

    private Book initBookEagerly(Book book) {
        int bookId = book.getId();
        book.setGenres(genreDao.findGenresByBookId(bookId));
        book.setAuthors(authorDao.findAllAuthorsByBookId(bookId));
        return book;
    }
}
