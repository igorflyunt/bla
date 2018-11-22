package com.softserve.librarymanager.dao;

import com.softserve.librarymanager.model.Genre;

import java.util.List;

public interface GenreDao {
    void save(Genre genre);

    void deleteById(int genreId);

    void update(Genre genre);

    Genre findById(int genreId);

    List<Genre> findGenresByBookId(int bookId);

    List<Genre> findGenresByAuthorId(int authorId);
}
