package com.softserve.bookworm.dao;

import com.softserve.bookworm.model.Author;
import com.softserve.bookworm.model.Book;
import com.softserve.bookworm.model.Genre;

import java.util.List;

public interface GenreDao extends Dao<Genre> {
    List<Genre> findGenresByBookId(int bookId);

    List<Genre> findGenresByAuthorId(int authorId);

    void saveAuthorGenre(Genre genre, Author author);

    void saveBookGenre(Genre genre, Book book);
}
