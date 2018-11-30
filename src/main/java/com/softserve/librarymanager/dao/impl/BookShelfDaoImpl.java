package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.AbstractDao;
import com.softserve.librarymanager.dao.BookShelfDao;
import com.softserve.librarymanager.dao.Dao;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.dao.mapper.impl.BookShelfMapper;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.db.JDBCQuery;
import com.softserve.librarymanager.model.BookShelf;

import java.util.List;

public class BookShelfDaoImpl extends AbstractDao<BookShelf> implements BookShelfDao, Dao<BookShelf> {
    private static final String SQL_INSERT_SHELF       = "insert into book_shelf (user_id, book_id, shelf_name)"
                                                         + " values(?, ?, ?) on duplicate key update shelf_name = ?";
    private static final String SQL_SELECT_ONE_SHELF = "select * from book_shelf where shelf_name = ? and user_id = ?";
    private static final String SQL_SELECT_ALL_SHELVES = "select * from book_shelf where user_id = ?";

    public BookShelfDaoImpl() {
        this(new TableDefinition("book_shelf", "id"), new BookShelfMapper());
    }

    private BookShelfDaoImpl(TableDefinition tableDefinition, EntityMapper<BookShelf> entityMapper) {
       super(tableDefinition, entityMapper);
    }

    @Override
    public List<BookShelf> findShelfByNameAndUserId(String shelfName, int userId) {
        return JDBCQuery.selectMany(SQL_SELECT_ONE_SHELF, new BookShelfMapper(), shelfName, userId);
    }

    @Override
    public List<BookShelf> findAllShelvesByUserId(int userId) {
        return JDBCQuery.selectMany(SQL_SELECT_ALL_SHELVES, new BookShelfMapper(), userId);
    }

    @Override
    public void saveOrUpdate(BookShelf entity) {
        JDBCQuery.update(entity, SQL_INSERT_SHELF, entity.getUser().getId(), entity.getBook().getId(),
                entity.getBookShelfName(),
                entity.getBookShelfName());
    }
}
