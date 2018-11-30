package com.softserve.librarymanager.dao;

import com.softserve.librarymanager.model.BookShelf;

import java.util.List;

public interface UserShelfDao extends Dao<BookShelf> {
    List<BookShelf> findShelfByNameAndUserId(String shelfName, int userId);

    List<BookShelf> findAllShelvesByUserId(int userId);
}
