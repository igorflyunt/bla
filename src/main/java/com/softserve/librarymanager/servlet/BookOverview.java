package com.softserve.librarymanager.servlet;

import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.impl.AuthorDaoImpl;
import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.dao.impl.GenericDao;
import com.softserve.librarymanager.model.Author;
import com.softserve.librarymanager.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/books")
public class BookOverview extends HttpServlet {
    private BookDao   bookDao   = new BookDaoImpl();
    private AuthorDao authorDao = new AuthorDaoImpl();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Book> books = bookDao.findAll();
        for (Book book : books) {
            book.setAuthors(authorDao.findAllAuthorsByBookId(book.getId()));
        }
        request.setAttribute("books", books);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
