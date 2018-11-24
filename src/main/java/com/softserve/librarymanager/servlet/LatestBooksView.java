package com.softserve.librarymanager.servlet;

import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class LatestBooksView extends HttpServlet {
    private BookDao bookDao = new BookDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> tenLatestBooks = bookDao.findTenLatestBooks();
        request.setAttribute("books", tenLatestBooks);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
