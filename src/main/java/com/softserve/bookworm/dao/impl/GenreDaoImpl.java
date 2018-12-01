package com.softserve.bookworm.dao.impl;

import com.softserve.bookworm.dao.AbstractDao;
import com.softserve.bookworm.dao.Dao;
import com.softserve.bookworm.dao.GenreDao;
import com.softserve.bookworm.dao.mapper.EntityMapper;
import com.softserve.bookworm.dao.mapper.impl.GenreMapper;
import com.softserve.bookworm.dao.table.TablePrimaryKeyPair;
import com.softserve.bookworm.db.JDBCQuery;
import com.softserve.bookworm.model.Author;
import com.softserve.bookworm.model.Book;
import com.softserve.bookworm.model.Genre;

import java.util.List;

public class GenreDaoImpl extends AbstractDao<Genre> implements GenreDao, Dao<Genre> {
    private static final String genreAlias = "g";
    private static final String genreAuthorAlias = "ga";
    private static final String genreBookAlias = "gb";

    private static final String SQL_INSERT_GENRE = "insert into genre (name) values(?)";
    private static final String SQL_INSERT_GENRE_INTO_AUTHOR = "insert into genre_author (genre_id, author_id)" +
            " values(?, ?)";
    private static final String SQL_INSERT_GENRE_INTO_BOOK = "insert into genre_book (genre_id, book_id)" +
            " values(?, ?)";
    private static final String SQL_UPDATE_GENRE = "update genre set name = ? where id = ?";
    private static final String SQL_SELECT_GENRES_BY_AUTHOR_ID = String.format(
            "select %s.* from genre %s" +
            " inner join genre_author %s" +
            " on %s.id = %s.genre_id" +
            " where %s.author_id = ?",
            genreAlias, genreAlias, genreAuthorAlias, genreAlias, genreAuthorAlias, genreAuthorAlias);
    private static final String SQL_SELECT_GENRES_BY_BOOK_ID = String.format(
            "select %s.* from genre %s" +
            " inner join genre_book %s" +
            " on %s.id = %s.genre_id" +
            " where %s.book_id = ?",
            genreAlias, genreAlias, genreBookAlias, genreAlias, genreBookAlias, genreBookAlias);

    public GenreDaoImpl() {
        this(TablePrimaryKeyPair.GENRE, new GenreMapper());
    }

    private GenreDaoImpl(TablePrimaryKeyPair tablePrimaryKeyPair, EntityMapper<Genre> entityMapper) {
        super(tablePrimaryKeyPair, entityMapper);
    }

    @Override
    public List<Genre> findGenresByBookId(int bookId) {
        return JDBCQuery.selectMany(SQL_SELECT_GENRES_BY_BOOK_ID, new GenreMapper(genreAlias), bookId);
    }

    @Override
    public List<Genre> findGenresByAuthorId(int authorId) {
        return JDBCQuery.selectMany(SQL_SELECT_GENRES_BY_AUTHOR_ID, new GenreMapper(genreAuthorAlias), authorId);
    }

    @Override
    public void saveAuthorGenre(Genre genre, Author author) {
        JDBCQuery.update(null, SQL_INSERT_GENRE_INTO_AUTHOR, genre.getId(), author.getId());
    }

    @Override
    public void saveBookGenre(Genre genre, Book book) {
        JDBCQuery.update(null, SQL_INSERT_GENRE_INTO_BOOK, genre.getId(), book.getId());
    }

    @Override
    public void saveOrUpdate(Genre entity) {
        int genreId = entity.getId();
        if (entityExists(genreId)) {
            JDBCQuery.update(entity, SQL_UPDATE_GENRE, genreId);
        } else {
            JDBCQuery.update(entity, SQL_INSERT_GENRE, entity.getGenreName());
        }
    }
}
