package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.Dao;
import com.softserve.librarymanager.dao.mapper.BookMapper;
import com.softserve.librarymanager.dao.table.Table;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.dao.table.column.BookColumns;
import com.softserve.librarymanager.db.DataSource;
import com.softserve.librarymanager.model.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends GenericCRUD<Book> implements BookDao, Dao<Book> {
    private static final String bookAlias = Table.BOOK.alias();
    private static final String authorAlias = Table.AUTHOR_BOOK.alias();

    private static final String SQL_INSERT_BOOK = "insert into book (name, description, first_published)" +
            " values (?, ?, ?)";
    private static final String SQL_UPDATE_BOOK = "update book" +
            " set name = ?, description = ?," +
            " first_published = ?" +
            " where id = ?";

    private static final String SQL_SELECT_BOOKS_BY_AUTHOR_ID = String.format(
            "select %s.* from book %s" +
            " inner join author_book %s" +
            " on %s.id = %s.book_id" +
            " where %s.author_id = ?",
            bookAlias, bookAlias, authorAlias, bookAlias, authorAlias, authorAlias);

    public BookDaoImpl() {
        this(new TableDefinition(Table.BOOK.table(), BookColumns.ID), new BookMapper());
    }

    private BookDaoImpl(TableDefinition tableDefinition, BookMapper entityMapper) {
        super(tableDefinition, entityMapper);
    }


    @Override
    public List<Book> findAllBooksByAuthorId(int authorId) {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement st = DataSource.getDbConnection().prepareStatement(SQL_SELECT_BOOKS_BY_AUTHOR_ID);
            st.setInt(1, authorId);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Book book = new BookMapper().mapToEntity(resultSet, bookAlias);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;
    }

    @Override
    public void save(Book entity) {
        Book book = findById(entity.getId());
        if (book == null) {
            save(entity, SQL_INSERT_BOOK, entity.getName(), entity.getDescription(),
                    entity.getFirstPublished());
        } else {
            save(entity, SQL_UPDATE_BOOK, entity.getName(), entity.getDescription(),
                    entity.getFirstPublished(), entity.getId());
        }
    }
}
