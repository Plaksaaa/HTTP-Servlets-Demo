package com.plaxa.http.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.getRequestDispatcher("/flights")
                .forward(req, resp);

        try (var writer = resp.getWriter()) {
            writer.write("Hello");
        }*/

        resp.sendRedirect("/flights");

//        req.setAttribute("1", "228");
    }
}
