package com.softserve.librarymanager.service;

import com.softserve.librarymanager.model.BookShelf;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BookShelfService extends Service<BookShelf> {
    void saveBookToShelf(int userId, HttpServletRequest bookShelfRequest);

    List<BookShelf> findShelfByNameAndUserId(String shelfName, int userId);

    List<BookShelf> findAllShelvesByUserId(int userId);
}
