package com.softserve.librarymanager.dao;

import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.model.BookShelf;

import java.util.List;

public interface BookShelfDao extends Dao<BookShelf> {
    List<Book> getBooksByShelfName(String shelfName);
}
