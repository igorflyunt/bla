package com.softserve.bookworm.dao.impl;

import com.softserve.bookworm.dao.AbstractDao;
import com.softserve.bookworm.dao.AuthorDao;
import com.softserve.bookworm.dao.Dao;
import com.softserve.bookworm.dao.mapper.EntityMapper;
import com.softserve.bookworm.dao.mapper.impl.AuthorMapper;
import com.softserve.bookworm.dao.table.TablePrimaryKeyPair;
import com.softserve.bookworm.db.JDBCQuery;
import com.softserve.bookworm.model.Author;

import java.util.List;

public class AuthorDaoImpl extends AbstractDao<Author> implements AuthorDao, Dao<Author> {
    private static final String authorBookAlias = "ab";
    private static final String authorAlias = "a";

    private static final String SQL_INSERT_AUTHOR = "insert into author (first_name, last_name, birth_date, biography)" +
            "values(?, ?, ?, ?)";
    private static final String SQL_UPDATE_AUTHOR = "update author set first_name = ?, last_name = ?, birth_date = ?,"
                                                    + " biography = ?" + " where id = ?";
    private static final String SQL_SELECT_AUTHORS_BY_BOOK_ID = String.format(
            "select %s.* from author %s" +
            " inner join author_book %s" +
            " on %s.id = %s.author_id" +
            " where %s.book_id = ?",
            authorAlias, authorAlias, authorBookAlias, authorAlias, authorBookAlias, authorBookAlias);

    public AuthorDaoImpl() {
        this(TablePrimaryKeyPair.AUTHOR, new AuthorMapper());
    }

    private AuthorDaoImpl(TablePrimaryKeyPair tablePrimaryKeyPair, EntityMapper<Author> entityMapper) {
        super(tablePrimaryKeyPair, entityMapper);
    }

    @Override
    public List<Author> findAuthorsByBookId(int bookId) {
        return JDBCQuery.selectMany(SQL_SELECT_AUTHORS_BY_BOOK_ID, new AuthorMapper(authorAlias), bookId);
    }

    @Override
    public void saveOrUpdate(Author entity) {
        int authorId = entity.getId();
        if (entityExists(authorId)) {
            JDBCQuery.update(entity, SQL_UPDATE_AUTHOR, entity.getFirstName(), entity.getLastName(), entity.getBirthDate(),
                    entity.getBiography(),
                    authorId);
        } else {
            JDBCQuery.update(entity, SQL_INSERT_AUTHOR, entity.getFirstName(), entity.getLastName(), entity.getBirthDate(),
                    entity.getBiography());
        }
    }
}
