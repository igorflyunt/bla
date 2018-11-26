package com.softserve.librarymanager.dao.mapper;

import com.softserve.librarymanager.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.softserve.librarymanager.dao.table.column.GenreColumns.ID;
import static com.softserve.librarymanager.dao.table.column.GenreColumns.NAME;
import static com.softserve.librarymanager.dao.table.util.ColumnUtil.addAliasIfProvided;

public class GenreMapper extends AbstractMapper<Genre> implements EntityMapper<Genre> {
    public GenreMapper() {
    }

    public GenreMapper(String columnAlias) {
        super(columnAlias);
    }

    @Override
    public Genre mapToEntity(ResultSet resultSet) throws SQLException {
        Genre genre = new Genre();
        genre.setId(resultSet.getInt(addAliasIfProvided(ID, columnAlias)));
        genre.setGenreName(resultSet.getString(addAliasIfProvided(NAME, columnAlias)));
        return genre;
    }
}
