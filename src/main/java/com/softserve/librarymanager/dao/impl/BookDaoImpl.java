package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.Dao;
import com.softserve.librarymanager.dao.mapper.BookMapper;
import com.softserve.librarymanager.dao.table.Table;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.dao.table.column.BookColumns;
import com.softserve.librarymanager.model.Author;
import com.softserve.librarymanager.model.Book;

import java.util.List;

public class BookDaoImpl extends GenericDao<Book> implements BookDao, Dao<Book> {
    private static final String bookAlias = Table.BOOK.alias();
    private static final String authorAlias = Table.AUTHOR_BOOK.alias();

    private static final String SQL_INSERT_BOOK = "insert into book (name, description, first_published)" +
            " values (?, ?, ?)";
    private static final String SQL_INSERT_BOOK_INTO_AUTHOR = "insert into author_book (author_id, book_id)" +
            " values (?, ?)";
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
        return query(SQL_SELECT_BOOKS_BY_AUTHOR_ID, new BookMapper(bookAlias), authorId);
    }

    @Override
    public void saveBookAuthor(Author author, Book book) {
        save(null, SQL_INSERT_BOOK_INTO_AUTHOR, author.getId(), book.getId());
    }

    @Override
    public void save(Book entity) {
        if (entityExists(entity)) {
            save(entity, SQL_INSERT_BOOK, entity.getName(), entity.getDescription(),
                    entity.getFirstPublished());
        } else {
            save(entity, SQL_UPDATE_BOOK, entity.getName(), entity.getDescription(),
                    entity.getFirstPublished(), entity.getId());
        }
    }
}
