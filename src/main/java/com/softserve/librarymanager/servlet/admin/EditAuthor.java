package com.softserve.librarymanager.servlet.admin;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.model.Author;
import com.softserve.librarymanager.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns={"/admin/author"})
@Singleton
public class EditAuthor extends HttpServlet {
    @Inject
    private AuthorService authorService;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Author> authors = authorService.findAll();
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("/view/admin/AuthorEditor.jsp").forward(request, response);
    }
}
