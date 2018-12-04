package com.softserve.bookworm.servlet.admin;

import com.google.inject.Singleton;
import com.softserve.bookworm.servlet.validator.UserCredentialsValidator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
@Singleton
public class AdminHomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("admin/author");
    }
}
