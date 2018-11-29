package com.softserve.librarymanager.dao.mapper;

import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.model.BookShelf;
import com.softserve.librarymanager.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookShelfMapper extends AbstractMapper<BookShelf> implements EntityMapper<BookShelf> {
    public BookShelfMapper() {
    }

    public BookShelfMapper(String columnAlias) {
        super(columnAlias);
    }

    @Override
    public BookShelf mapToEntity(ResultSet resultSet) throws SQLException {
        BookShelf bookShelf = new BookShelf();
        String shelfName = resultSet.getString("shelf_name");
        Book book = new Book();
        User user = new User();
        book.setId(resultSet.getInt("book_id"));
        user.setId(resultSet.getInt("user_id"));
        bookShelf.setBook(book);
        bookShelf.setUser(user);
        bookShelf.setBookShelfName(shelfName);
        return bookShelf;
    }
}
