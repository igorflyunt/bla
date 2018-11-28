package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.UserDao;
import com.softserve.librarymanager.dao.mapper.BookMapper;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.dao.mapper.UserMapper;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.model.User;

import java.util.List;

public class UserDaoImpl extends GenericDao<User> implements UserDao {
    private static final String SQL_INSERT_USER = "insert into user (first_name, last_name, role, username, password)"
                                                  + " values (?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_BOOKS_BY_USER_ID = "select b.* from book b"
                                                              + " inner join book_shelf bs"
                                                              + " on b.id = bs.book_id"
                                                              + " where bs.user_id = ? ";
    private static final String SQL_SELECT_USER_BY_USERNAME = "select * from user where username = ?";

    public UserDaoImpl() {
        this(new TableDefinition("user", "id"), new UserMapper());
    }

    private UserDaoImpl(TableDefinition tableDefinition, EntityMapper<User> entityMapper) {
        super(tableDefinition, entityMapper);
    }

    @Override
    public User findUserByUsername(String username) {
        return selectOne(SQL_SELECT_USER_BY_USERNAME, new UserMapper(), username);
    }

    @Override
    public List<Book> findBooksByUserId(int userId) {
        return selectMany(SQL_SELECT_BOOKS_BY_USER_ID, new BookMapper("b"), userId);
    }

    @Override
    public void save(User entity) {
        save(entity, SQL_INSERT_USER, entity.getFirstName(), entity.getLastName(), entity.getRole(),
                entity.getUsername(),
                entity.getPassword());
    }
}
