package com.softserve.librarymanager.dao.mapper.impl;

import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements EntityMapper<User> {
    @Override
    public User mapToEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
