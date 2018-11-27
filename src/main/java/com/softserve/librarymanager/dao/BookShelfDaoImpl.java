package com.softserve.librarymanager.dao;

import com.google.inject.Inject;
import com.softserve.librarymanager.dao.impl.GenericDao;
import com.softserve.librarymanager.dao.mapper.BookShelfMapper;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.dao.table.Table;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.dao.table.column.AuthorColumns;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.model.BookShelf;

import java.util.List;

public class BookShelfDaoImpl extends GenericDao<BookShelf> implements BookShelfDao, Dao<BookShelf> {
    @Inject

    public BookShelfDaoImpl() {
        this(new TableDefinition(Table.AUTHOR.table(), AuthorColumns.ID), new BookShelfMapper());
    }

    private BookShelfDaoImpl(TableDefinition tableDefinition, EntityMapper<BookShelf> entityMapper) {
        super(tableDefinition, entityMapper);
    }

    @Override
    public List<Book> getBooksByShelfName(String shelfName) {
        return null;
    }

    @Override
    public void save(BookShelf entity) {

    }

    @Override
    public void delete(BookShelf entity) {

    }
}
