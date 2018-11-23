package com.softserve.librarymanager.dao;

import com.softserve.librarymanager.model.Author;
import com.softserve.librarymanager.model.Genre;

import java.util.List;

public interface GenreDao extends Dao<Genre> {
    List<Genre> findGenresByBookId(int bookId);

    List<Genre> findGenresByAuthorId(int authorId);

    void saveAuthorGenre(Genre genre, Author author);
}
