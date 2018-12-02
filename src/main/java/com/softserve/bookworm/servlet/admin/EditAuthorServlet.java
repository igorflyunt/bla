package com.softserve.bookworm.servlet.admin;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.bookworm.model.AbstractEntity;
import com.softserve.bookworm.model.Author;
import com.softserve.bookworm.service.AuthorService;
import com.softserve.bookworm.servlet.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/author")
@Singleton
public class EditAuthorServlet extends HttpServlet {
    @Inject
    private AuthorService authorService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        authorService.save(request);
        response.sendRedirect("/admin/author");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> authors = authorService.findAll();
        request.setAttribute("authors", authors);
        request.getRequestDispatcher(Jsp.AUTHOR_EDITOR_VIEW).forward(request, response);
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
