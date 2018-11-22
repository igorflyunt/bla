package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.dao.table.GenreAuthorColumns;
import com.softserve.librarymanager.dao.table.GenreBookColumns;
import com.softserve.librarymanager.dao.table.GenreColumns;
import com.softserve.librarymanager.dao.table.Table;
import com.softserve.librarymanager.dao.table.util.ColumnUtil;
import com.softserve.librarymanager.db.ParameterizedStatement;
import com.softserve.librarymanager.db.builder.SelectQueryBuilder;
import com.softserve.librarymanager.model.Genre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl implements GenreDao {
    private static final String INSERT_GENRE_QUERY = "insert into genre (name) values (:name)";
    private static final String DELETE_GENRE_QUERY = "delete from genre where id = :id";
    private static final String UPDATE_GENRE_QUERY = "update genre set name = :name where id = :id";

    private static final String SELECT_GENRE_BY_ID_QUERY;
    private static final String SELECT_GENRE_BY_AUTHOR_ID_QUERY;
    private static final String SELECT_GENRE_BY_BOOK_ID_QUERY;

    static {
        SELECT_GENRE_BY_ID_QUERY =  new SelectQueryBuilder().select().addColumn(GenreColumns.ALL.field())
                .from(Table.GENRE.table())
                .where().equal(GenreColumns.ID.field(), GenreColumns.ID.param()).buildQuery();

        SELECT_GENRE_BY_AUTHOR_ID_QUERY = new SelectQueryBuilder().select()
                .addColumn(GenreColumns.ALL.alias()).from(Table.GENRE.aliasedTable())
                .innerJoin(Table.AUTHOR.aliasedTable())
                .on(GenreColumns.ID.alias(), GenreAuthorColumns.GENRE_ID.alias())
                .where().equal(GenreAuthorColumns.AUTHOR_ID.alias(), GenreAuthorColumns.AUTHOR_ID.aliasedParam())
                .buildQuery();

        SELECT_GENRE_BY_BOOK_ID_QUERY = new SelectQueryBuilder().select()
                .addColumn(GenreColumns.ALL.alias())
                .from(Table.GENRE.aliasedTable())
                .innerJoin(Table.GENRE_BOOK.aliasedTable())
                .on(GenreColumns.ID.alias(), GenreBookColumns.GENRE_ID.alias())
                .where()
                .equal(GenreBookColumns.BOOK_ID.alias(), GenreBookColumns.BOOK_ID.aliasedParam())
                .buildQuery();
    }

    private ParameterizedStatement parameterizedStatement;

    @Override
    public void save(Genre genre) {
        try {
            parameterizedStatement = new ParameterizedStatement(INSERT_GENRE_QUERY);
            parameterizedStatement.setString(GenreColumns.NAME.param(), genre.getGenreName());
            PreparedStatement statement = parameterizedStatement.getPreparedStatement();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int genreId) {
        try {
            parameterizedStatement = new ParameterizedStatement(DELETE_GENRE_QUERY);
            parameterizedStatement.setInt(GenreColumns.ID.param(), genreId);
            PreparedStatement preparedStatement = parameterizedStatement.getPreparedStatement();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Genre genre) {
        try {
            parameterizedStatement = new ParameterizedStatement(UPDATE_GENRE_QUERY);
            parameterizedStatement.setInt(GenreColumns.ID.param(), genre.getId())
                    .setString(GenreColumns.NAME.param(), genre.getGenreName());
            PreparedStatement preparedStatement = parameterizedStatement.getPreparedStatement();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Genre findById(int genreId) {
        Genre genre = null;
        try {
            parameterizedStatement = new ParameterizedStatement(SELECT_GENRE_BY_ID_QUERY);
            parameterizedStatement.setInt(GenreColumns.ID.param(), genreId);
            PreparedStatement preparedStatement = parameterizedStatement.getPreparedStatement();
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            genre = toGenre(resultSet, Table.NO_TABLE.alias());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre;
    }

    @Override
    public List<Genre> findGenresByBookId(int bookId) {
        List<Genre> genres = null;
        try {
            parameterizedStatement = new ParameterizedStatement(SELECT_GENRE_BY_BOOK_ID_QUERY);
            parameterizedStatement.setInt(GenreBookColumns.BOOK_ID.aliasedParam(), bookId);
            PreparedStatement preparedStatement = parameterizedStatement.getPreparedStatement();
            ResultSet resultSet = preparedStatement.executeQuery();
            genres = toGenreList(resultSet, Table.GENRE.alias());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    @Override
    public List<Genre> findGenresByAuthorId(int authorId) {
        List<Genre> genres = new ArrayList<>();
        try {
            parameterizedStatement = new ParameterizedStatement(SELECT_GENRE_BY_AUTHOR_ID_QUERY);
            parameterizedStatement.setInt(GenreAuthorColumns.AUTHOR_ID.aliasedParam(), authorId);
            PreparedStatement statement = parameterizedStatement.getPreparedStatement();
            genres = toGenreList(statement.executeQuery(), Table.GENRE.alias());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    private static List<Genre> toGenreList(ResultSet resultSet, String columnAlias)
            throws SQLException {
        List<Genre> genres = new ArrayList<>();
        while (resultSet.next()) {
            Genre genre = toGenre(resultSet, columnAlias);
            genres.add(genre);
        }
        return genres;
    }

    private static Genre toGenre(ResultSet resultSet, String columnAlias) throws SQLException {
        String id = ColumnUtil.createColumnWithAlias(GenreColumns.ID.field(), columnAlias);
        String name = ColumnUtil.createColumnWithAlias(GenreColumns.NAME.field(), columnAlias);
        Genre genre = new Genre();
        genre.setId(resultSet.getInt(id));
        genre.setGenreName(resultSet.getString(name));
        return genre;
    }
}
