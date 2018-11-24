package com.softserve.librarymanager.service;

import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.impl.AuthorDaoImpl;
import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.model.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDaoImpl();
    private AuthorDao authorDao = new AuthorDaoImpl();

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

    private void setBookAuthors(List<Book> books) {
        for (Book book : books) {
            book.setAuthors(authorDao.findAllAuthorsByBookId(book.getId()));
        }
    }
}
