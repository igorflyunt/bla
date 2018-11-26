package com.softserve.librarymanager.servlet.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.service.BookService;
import com.softserve.librarymanager.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
@Singleton
public class BookView extends HttpServlet {
    @Inject
    private BookService bookService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        bookService.findById(bookid).ifPresent(b-> request.setAttribute("book", b));
        request.getRequestDispatcher("view/user/BookView.jsp").forward(request, response);
    }
}
