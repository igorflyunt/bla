package com.softserve.librarymanager.dao.mapper.impl;

import com.softserve.librarymanager.dao.mapper.AbstractMapper;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        book.setId(resultSet.getInt(addAliasIfProvided("id", columnAlias)));
        book.setBookName(resultSet.getString(addAliasIfProvided("name", columnAlias)));
        book.setDescription(resultSet.getString(addAliasIfProvided("description", columnAlias)));
        book.setFirstPublished(resultSet.getDate(addAliasIfProvided("first_published", columnAlias)));
        return book;
    }
}
