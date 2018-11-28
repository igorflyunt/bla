package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.BookShelfDao;
import com.softserve.librarymanager.dao.Dao;
import com.softserve.librarymanager.dao.mapper.BookMapper;
import com.softserve.librarymanager.dao.mapper.BookShelfMapper;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.db.JDBCQuery;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.model.BookShelf;

import java.util.List;

public class BookShelfDaoImpl extends AbstractDao<BookShelf> implements BookShelfDao, Dao<BookShelf> {
    private static final String SQL_INSERT_SHELF = "insert into book_shelf (user_id, book_id, shelf_name)"
                                                   + "values(?, ?, ?)"
                                                   + "ON DUPLICATE KEY UPDATE shelf_name";
    private static final String SQL_SELECT_SHELF = "select b.* from book_shelf bs" + "inner join book b"
                                                   + "on bs.book_id = b.id"
                                                   + "where bs.author_id = ? and bs.shelf_name = ?";

    public BookShelfDaoImpl() {
        this(new TableDefinition("book_shelf", "id"), new BookShelfMapper());
    }

    private BookShelfDaoImpl(TableDefinition tableDefinition, EntityMapper<BookShelf> entityMapper) {
       super(tableDefinition, entityMapper);
    }

    @Override
    public List<Book> getBooksByShelfNameAndAuthorId(String shelfName, int authorId) {
        return JDBCQuery.selectMany(SQL_SELECT_SHELF, new BookMapper("b"), shelfName, authorId);
    }

    @Override
    public void save(BookShelf entity) {
        JDBCQuery.update(entity, SQL_INSERT_SHELF, entity.getAuthorId(), entity.getBookId(), entity.getBookShelfName());
    }
}
