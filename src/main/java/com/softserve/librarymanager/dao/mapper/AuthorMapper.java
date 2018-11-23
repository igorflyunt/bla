package com.softserve.librarymanager.dao.mapper;

import com.softserve.librarymanager.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.softserve.librarymanager.dao.table.column.AuthorColumns.*;
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
        author.setId((resultSet.getInt(addAliasIfProvided(ID, columnAlias))));
        author.setFirstName((resultSet.getString(addAliasIfProvided(FIRST_NAME, columnAlias))));
        author.setLastName((resultSet.getString(addAliasIfProvided(LAST_NAME, columnAlias))));
        author.setBirthDate((resultSet.getDate(addAliasIfProvided(BIRTH_DATE, columnAlias))));
        return author;
    }
}
