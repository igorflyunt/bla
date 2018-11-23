package com.softserve.librarymanager.dao.mapper;

import com.softserve.librarymanager.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.softserve.librarymanager.dao.table.util.ColumnUtil.appendAlias;

public class BookMapper implements EntityMapper<Book> {

    @Override
    public Book mapToEntity(ResultSet resultSet, String columnAlias) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt(appendAlias("id", columnAlias)));
        book.setBookName(resultSet.getString(appendAlias("name", columnAlias)));
        book.setDescription(resultSet.getString(appendAlias("description", columnAlias)));
        book.setFirstPublished(resultSet.getDate(appendAlias("first_published", columnAlias)));
        return book;
    }
}
