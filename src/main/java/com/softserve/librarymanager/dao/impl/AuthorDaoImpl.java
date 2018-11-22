package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.table.BookColumns;
import com.softserve.librarymanager.dao.util.QueryUtil;
import com.softserve.librarymanager.db.ParameterizedStatement;
import com.softserve.librarymanager.model.Book;
import sun.tracing.PrintStreamProviderFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
//    private static final String INSERT_BOOK_QUERY;
//    private static final String UPDATE_BOOK_QUERY;

/*
    static {
        INSERT_BOOK_QUERY = "insert into author";
    }
*/


    private ParameterizedStatement parameterizedStatement;

    @Override
    public void saveOrUpdate(Book book) {
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public List<Book> findAllBooksByAuthorId(int bookId) {
        return null;
    }
}
