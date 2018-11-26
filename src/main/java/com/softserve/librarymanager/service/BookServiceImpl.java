package com.softserve.librarymanager.service;

import com.google.inject.Inject;
import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.dao.impl.GenreDaoImpl;
import com.softserve.librarymanager.model.Book;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl extends AbstractService<Book, BookDao> implements BookService {
    @Inject
    private AuthorService authorDao;

    @Inject
    private GenreDao genreDao;

    @Inject
    public BookServiceImpl(BookDao dao) {
        super(dao);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = getDao().findAll();
        books.forEach(this::initBookEagerly);
        return books;
    }

    @Override
    public List<Book> findBooksByAuthorId(int authorId) {
        List<Book> books = getDao().findAllBooksByAuthorId(authorId);
        books.forEach(this::initBookEagerly);
        return books;
    }

    @Override
    public List<Book> findTenLatestBooks() {
        List<Book> books = getDao().findTenLatestBooks();
        books.forEach(this::initBookEagerly);
        return books;
    }

    @Override
    public void mapBookToAuthor(int bookId, int authorId) {
        getDao().mapBookToAuthor(bookId, authorId);
    }

    public Optional<Book> findById(int bookId) {
        return getDao().findById(bookId).map(this::initBookEagerly);
    }

    private Book initBookEagerly(Book book) {
        int bookId = book.getId();
        book.setGenres(genreDao.findGenresByBookId(bookId));
        book.setAuthors(authorDao.findAuthorsByBookId(bookId));
        return book;
    }
}
