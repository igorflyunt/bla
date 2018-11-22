package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.table.AuthorBookColumns;
import com.softserve.librarymanager.dao.table.AuthorColumns;
import com.softserve.librarymanager.dao.table.BookColumns;
import com.softserve.librarymanager.dao.table.Table;
import com.softserve.librarymanager.dao.table.util.ColumnUtil;
import com.softserve.librarymanager.dao.util.QueryUtil;
import com.softserve.librarymanager.db.ParameterizedStatement;
import com.softserve.librarymanager.db.builder.SelectQueryBuilder;
import com.softserve.librarymanager.model.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final String INSERT_BOOK_QUERY = "insert into book (name, description, first_published)" +
            " values (:name, :description, :first_published)";
    private static final String DELETE_BOOK_BY_ID_QUERY = "delete from book where id = :id";
    private static final String UPDATE_BOOK_QUERY = "update book" +
            " set name = :name," +
            " description = :description," +
            " first_published = :first_published where id = :id";

    private static final String SELECT_ALL_BOOKS = "select * from book";
    private static final String SELECT_ALL_BOOKS_BY_AUTHOR_ID;

    static {
        SELECT_ALL_BOOKS_BY_AUTHOR_ID = new SelectQueryBuilder().select().addColumn(BookColumns.ALL.alias())
                .from(Table.GENRE.aliasedTable()).innerJoin(Table.AUTHOR_BOOK.aliasedTable())
                .on(BookColumns.ID.alias(), AuthorBookColumns.BOOK_ID.alias())
                .where().equal(AuthorColumns.ID.alias(), AuthorColumns.ID.aliasedParam()).buildQuery();
    }

    private ParameterizedStatement parameterizedStatement;

    @Override
    public void saveOrUpdate(Book book) {
        try {
            String updateOrSaveQuery = INSERT_BOOK_QUERY;
            if (QueryUtil.entityExists(book)) {
                updateOrSaveQuery = UPDATE_BOOK_QUERY;
            }
            parameterizedStatement = new ParameterizedStatement(updateOrSaveQuery);
            parameterizedStatement.setString(BookColumns.NAME.param(), book.getBookName());
            parameterizedStatement.setString(BookColumns.DESCRIPTION.param(), book.getDescription());
            parameterizedStatement.setDate(BookColumns.FIRST_PUBLISHED.param(), book.getFirstPublished());
            parameterizedStatement.setInt(BookColumns.ID.param(), book.getId());
            PreparedStatement st = parameterizedStatement.getPreparedStatement();
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            parameterizedStatement = new ParameterizedStatement(DELETE_BOOK_BY_ID_QUERY);
            parameterizedStatement.setInt(BookColumns.ID.param(), id);
            parameterizedStatement.getPreparedStatement().executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        try {
            parameterizedStatement = new ParameterizedStatement("select * from book where id = :id");
            parameterizedStatement.setInt(BookColumns.ID.param(), id);
            ResultSet resultSet = parameterizedStatement.getPreparedStatement().executeQuery();
            resultSet.next();
            book = toBook(resultSet, Table.NO_TABLE.alias());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            parameterizedStatement = new ParameterizedStatement(SELECT_ALL_BOOKS);
            ResultSet resultSet = parameterizedStatement.getPreparedStatement().executeQuery();
            while (resultSet.next()) {
                Book book = toBook(resultSet, Table.NO_TABLE.alias());
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> findAllBooksByAuthorId(int bookId) {
        List<Book> books = new ArrayList<>();
        try {
            parameterizedStatement = new ParameterizedStatement(SELECT_ALL_BOOKS_BY_AUTHOR_ID);
            parameterizedStatement.setInt(AuthorColumns.ID.aliasedParam(), bookId);
            ResultSet resultSet = parameterizedStatement.getPreparedStatement().executeQuery();
            while (resultSet.next()) {
                Book book = toBook(resultSet, Table.GENRE.alias());
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    private static Book toBook(ResultSet resultSet, String columnAlias) throws SQLException {
        Book book = new Book();
        String id = ColumnUtil.createColumnWithAlias(BookColumns.ID.field(), columnAlias);
        String name = ColumnUtil.createColumnWithAlias(BookColumns.NAME.field(), columnAlias);
        String description = ColumnUtil.createColumnWithAlias(BookColumns.DESCRIPTION.field(), columnAlias);
        String firstPublished = ColumnUtil.createColumnWithAlias(BookColumns.FIRST_PUBLISHED.field(), columnAlias);
        book.setId(resultSet.getInt(id));
        book.setBookName(resultSet.getString(name));
        book.setDescription(resultSet.getString(description));
        book.setFirstPublished(resultSet.getDate(firstPublished));
        return book;
    }
}
