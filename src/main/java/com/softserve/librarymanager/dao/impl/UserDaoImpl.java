package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.UserDao;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.dao.mapper.UserMapper;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.model.User;

import java.util.List;

public class UserDaoImpl extends GenericDao<User> implements UserDao {
    public UserDaoImpl() {
        this(new TableDefinition("user", "id"), new UserMapper());
    }

    private UserDaoImpl(TableDefinition tableDefinition, EntityMapper<User> entityMapper) {
        super(tableDefinition, entityMapper);
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<Book> findBooksByUserId(int userId) {
        return null;
    }

    @Override
    public void save(User entity) {

    }
}
