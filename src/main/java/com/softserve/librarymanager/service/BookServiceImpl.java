package com.softserve.librarymanager.service;

import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.dao.impl.GenreDaoImpl;
import com.softserve.librarymanager.model.Book;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl extends AbstractService<Book, BookDaoImpl> implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    private AuthorService authorDao = new AuthorServiceImpl();
    private GenreDao genreDao =  new GenreDaoImpl();

    public BookServiceImpl() {
        super(new BookDaoImpl());
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = bookDao.findAll();
        books.forEach(this::initBookEagerly);
        return books;
    }

    @Override
    public List<Book> findBooksByAuthorId(int authorId) {
        List<Book> books = bookDao.findAllBooksByAuthorId(authorId);
        books.forEach(this::initBookEagerly);
        return books;
    }

    @Override
    public List<Book> findTenLatestBooks() {
        List<Book> books = bookDao.findTenLatestBooks();
        books.forEach(this::initBookEagerly);
        return books;
    }

    public Optional<Book> findById(int bookId) {
        return bookDao.findById(bookId).map(this::initBookEagerly);
    }

    private Book initBookEagerly(Book book) {
        int bookId = book.getId();
        book.setGenres(genreDao.findGenresByBookId(bookId));
        book.setAuthors(authorDao.findAuthorsByBookId(bookId));
        return book;
    }
}
