package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.Dao;
import com.softserve.librarymanager.dao.mapper.AuthorMapper;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.dao.table.Table;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.dao.table.column.AuthorColumns;
import com.softserve.librarymanager.model.Author;

import java.util.List;

public class AuthorDaoImpl extends GenericDao<Author> implements AuthorDao, Dao<Author> {
    private static final String authorBookAlias = Table.AUTHOR_BOOK.alias();
    private static final String authorAlias = Table.AUTHOR.alias();

    private static final String SQL_INSERT_AUTHOR = "insert into author (first_name, last_name, birth_date, biography)" +
            "values(?, ?, ?)";
    private static final String SQL_UPDATE_AUTHOR = "update author set first_name = ?, last_name = ?, birth_date = ?,"
                                                    + " biography = ?" + " where id = ?";
    private static final String SQL_SELECT_AUTHORS_BY_BOOK_ID = String.format(
            "select %s.* from author %s" +
            " inner join author_book %s" +
            " on %s.id = %s.author_id" +
            " where %s.book_id = ?",
            authorAlias, authorAlias, authorBookAlias, authorAlias, authorBookAlias, authorBookAlias);

    public AuthorDaoImpl() {
        this(new TableDefinition(Table.AUTHOR.table(), AuthorColumns.ID), new AuthorMapper());
    }

    private AuthorDaoImpl(TableDefinition tableDefinition, EntityMapper<Author> entityMapper) {
        super(tableDefinition, entityMapper);
    }

    @Override
    public List<Author> findAuthorsByBookId(int bookId) {
        return query(SQL_SELECT_AUTHORS_BY_BOOK_ID, new AuthorMapper(authorAlias), bookId);
    }

    @Override
    public void save(Author entity) {
        if (entityExists(entity)) {
            save(entity, SQL_UPDATE_AUTHOR, entity.getFirstName(), entity.getLastName(), entity.getBirthDate(),
                    entity.getId());
        } else {
            save(entity, SQL_INSERT_AUTHOR, entity.getFirstName(), entity.getLastName(), entity.getBirthDate());
        }
    }
}
