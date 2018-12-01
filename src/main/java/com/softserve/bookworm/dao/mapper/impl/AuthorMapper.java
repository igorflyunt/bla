package com.softserve.bookworm.dao.mapper.impl;

import com.softserve.bookworm.dao.mapper.AbstractMapper;
import com.softserve.bookworm.dao.mapper.EntityMapper;
import com.softserve.bookworm.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.softserve.bookworm.dao.table.util.ColumnUtil.prependAliasIfNotEmpty;

public class AuthorMapper extends AbstractMapper<Author> implements EntityMapper<Author> {
    public AuthorMapper() {
    }

    public AuthorMapper(String columnAlias) {
        super(columnAlias);
    }

    @Override
    public Author mapToEntity(ResultSet resultSet) throws SQLException {
        Author author = new Author();
        author.setId((resultSet.getInt(prependAliasIfNotEmpty("id", columnAlias))));
        author.setFirstName((resultSet.getString(prependAliasIfNotEmpty("first_name", columnAlias))));
        author.setLastName((resultSet.getString(prependAliasIfNotEmpty("last_name", columnAlias))));
        author.setBirthDate((resultSet.getDate(prependAliasIfNotEmpty("birth_date", columnAlias))));
        author.setBiography((resultSet.getString(prependAliasIfNotEmpty("biography", columnAlias))));
        return author;
    }
}
