package com.softserve.bookworm.service;

import com.softserve.bookworm.model.BookShelf;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserShelfService extends Service<BookShelf> {
    void saveBookToShelf(int userId, HttpServletRequest bookShelfRequest);

    List<BookShelf> findShelfByNameAndUserId(String shelfName, int userId);

    List<BookShelf> findAllShelvesByUserId(int userId);
}
