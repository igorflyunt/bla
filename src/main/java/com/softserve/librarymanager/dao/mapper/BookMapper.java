package com.softserve.librarymanager.dao.mapper;

import com.softserve.librarymanager.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.softserve.librarymanager.dao.table.column.BookColumns.*;
import static com.softserve.librarymanager.dao.table.util.ColumnUtil.addAliasIfProvided;

public class BookMapper extends AbstractMapper<Book> implements EntityMapper<Book> {

    public BookMapper() {
        super();
    }

    public BookMapper(String columnAlias) {
        super(columnAlias);
    }

    @Override
    public Book mapToEntity(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt(addAliasIfProvided(ID, columnAlias)));
        book.setBookName(resultSet.getString(addAliasIfProvided(NAME, columnAlias)));
        book.setDescription(resultSet.getString(addAliasIfProvided(DESCRIPTION, columnAlias)));
        book.setFirstPublished(resultSet.getDate(addAliasIfProvided(FIRST_PUBLISHED, columnAlias)));
        return book;
    }
}
