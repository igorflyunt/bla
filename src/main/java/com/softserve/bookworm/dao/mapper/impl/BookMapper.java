package com.softserve.bookworm.dao.mapper.impl;

import com.softserve.bookworm.dao.mapper.AbstractMapper;
import com.softserve.bookworm.dao.mapper.EntityMapper;
import com.softserve.bookworm.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.softserve.bookworm.dao.table.util.ColumnUtil.prependAliasIfNotEmpty;

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
        book.setId(resultSet.getInt(prependAliasIfNotEmpty("id", columnAlias)));
        book.setBookName(resultSet.getString(prependAliasIfNotEmpty("name", columnAlias)));
        book.setDescription(resultSet.getString(prependAliasIfNotEmpty("description", columnAlias)));
        book.setFirstPublished(resultSet.getDate(prependAliasIfNotEmpty("first_published", columnAlias)));
        return book;
    }
}
