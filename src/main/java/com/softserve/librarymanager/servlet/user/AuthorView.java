package com.softserve.librarymanager.servlet.user;

import com.softserve.librarymanager.model.Author;
import com.softserve.librarymanager.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/author")
public class AuthorView extends HttpServlet {
    private AuthorService authorService = new AuthorService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        authorService.findAuthorById(authorId).ifPresent(author -> request.setAttribute("author", author));
        request.getRequestDispatcher("WEB-INF/AuthorView.jsp").forward(request, response);
    }
}
