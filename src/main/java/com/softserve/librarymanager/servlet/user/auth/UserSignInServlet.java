package com.softserve.librarymanager.servlet.user.auth;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.dao.UserDao;
import com.softserve.librarymanager.security.UserSession;
import com.softserve.librarymanager.servlet.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/auth/signin")
@Singleton
public class UserSignInServlet extends HttpServlet {
    @Inject
    UserSession userSession;

    @Inject
    private UserDao userDao;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userSession.addToSession(username, request);
        response.sendRedirect("/user/bookshelf?shelf=all");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(Jsp.USER_SIGN_IN_VIEW).forward(request, response);
    }
}
