package com.plaxa.http.servlet;

import com.plaxa.http.flight.service.FlightService;
import com.plaxa.http.flight.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("flights", flightService.findAll());

        req.getRequestDispatcher(JspHelper.getPath("flights"))
                        .forward(req, resp);

        /*resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var writer = resp.getWriter()) {
            writer.write("<h1>Список перелетов:</h1>");
            writer.write("<ul></ul>");
            writer.write("<ul>");
            flightService.findAll().forEach(flightDto -> {
                writer.write("""
                        <li>
                             <a href="/tickets?flightId=%d">%s</a>
                             
                        </li>
                        """.formatted(flightDto.getId(), flightDto.getDescription()));
            });
            writer.write("</ul>");
        }*/
    }
}
