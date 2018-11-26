package com.softserve.librarymanager.servlet.admin;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.model.AbstractEntity;
import com.softserve.librarymanager.model.Author;
import com.softserve.librarymanager.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/admin/author")
@Singleton
public class EditAuthor extends HttpServlet {
    @Inject
    private AuthorService authorService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String bio = request.getParameter("biography");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        Author author = new Author();
        setEntityIdIfExists(request.getParameter("id"), author);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBiography(bio);
        try {
            Date birthDate = format.parse(request.getParameter("birthDate"));
            author.setBirthDate(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        authorService.save(author);
        response.sendRedirect("/admin/author");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Author> authors = authorService.findAll();
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("/view/admin/AuthorEditor.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        authorService.findById(authorId).ifPresent(authorService::delete);
    }

    private void setEntityIdIfExists(String stringId, AbstractEntity entity) {
        if (stringId == null || stringId.isEmpty())
            return;
        int id = Integer.parseInt(stringId);
        entity.setId(id);
    }
}
