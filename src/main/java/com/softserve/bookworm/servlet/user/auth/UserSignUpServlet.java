package com.softserve.bookworm.servlet.user.auth;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.bookworm.dao.UserDao;
import com.softserve.bookworm.model.User;
import com.softserve.bookworm.servlet.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/auth/signup")
@Singleton
public class UserSignUpServlet extends HttpServlet {
    @Inject
    UserDao userDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        userDao.saveOrUpdate(user);
        response.sendRedirect("/user/auth/signin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher(Jsp.USER_SIGN_UP_VIEW).forward(request, response);
    }
}
