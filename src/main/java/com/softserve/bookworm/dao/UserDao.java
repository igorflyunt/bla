package com.softserve.bookworm.dao;

import com.softserve.bookworm.model.Book;
import com.softserve.bookworm.model.User;

import java.util.List;

public interface UserDao extends Dao<User> {
    User findUserByUsername(String username);

    List<Book> findBooksByUserId(int userId);
}
