package com.softserve.librarymanager.dao;

import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.model.User;

import java.util.List;

public interface UserDao extends Dao<User> {
    User findUserByUsername(String username);

    List<Book> findBooksByUserId(int userId);
}
