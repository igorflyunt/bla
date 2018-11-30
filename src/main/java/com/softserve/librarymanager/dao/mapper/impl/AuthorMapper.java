package com.softserve.librarymanager.dao.mapper.impl;

import com.softserve.librarymanager.dao.mapper.AbstractMapper;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.softserve.librarymanager.dao.table.util.ColumnUtil.addAliasIfProvided;

public class AuthorMapper extends AbstractMapper<Author> implements EntityMapper<Author> {
    public AuthorMapper() {
    }

    public AuthorMapper(String columnAlias) {
        super(columnAlias);
    }

    @Override
    public Author mapToEntity(ResultSet resultSet) throws SQLException {
        Author author = new Author();
        author.setId((resultSet.getInt(addAliasIfProvided("id", columnAlias))));
        author.setFirstName((resultSet.getString(addAliasIfProvided("first_name", columnAlias))));
        author.setLastName((resultSet.getString(addAliasIfProvided("last_name", columnAlias))));
        author.setBirthDate((resultSet.getDate(addAliasIfProvided("birth_date", columnAlias))));
        author.setBiography((resultSet.getString(addAliasIfProvided("biography", columnAlias))));
        return author;
    }
}
