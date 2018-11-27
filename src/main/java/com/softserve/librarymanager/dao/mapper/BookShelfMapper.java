package com.softserve.librarymanager.dao.mapper;

import com.softserve.librarymanager.model.BookShelf;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.softserve.librarymanager.model.BookShelf.BookShelves;

public class BookShelfMapper implements EntityMapper<BookShelf> {
    @Override
    public BookShelf mapToEntity(ResultSet resultSet) throws SQLException {
        BookShelf bookShelf = new BookShelf();
        final BookShelves shelfName = BookShelves.valueOf(resultSet.getString("shelf_name"));
        bookShelf.setId(resultSet.getInt("id"));
        bookShelf.setStatus(shelfName);
        return bookShelf;
    }
}
