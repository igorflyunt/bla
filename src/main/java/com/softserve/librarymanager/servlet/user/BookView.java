package com.softserve.librarymanager.servlet.user;

import com.softserve.librarymanager.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookView extends HttpServlet {
    private BookService bookService = new BookService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        bookService.findBookById(bookid).ifPresent(b-> request.setAttribute("book", b));
        request.getRequestDispatcher("WEB-INF/view/user/BookView.jsp").forward(request, response);
    }
}
