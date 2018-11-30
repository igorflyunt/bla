package com.softserve.bookworm.dao;

import com.softserve.bookworm.model.BookShelf;

import java.util.List;

public interface UserShelfDao extends Dao<BookShelf> {
    List<BookShelf> findShelfByNameAndUserId(String shelfName, int userId);

    List<BookShelf> findAllShelvesByUserId(int userId);
}
