package com.plaxa.http.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"filename.txt\"");
        resp.setContentType("application/json");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

//          не будет работать т.к наше приложение demo - не самостоятельное приложение
//          мы его только заворачиваем в war archieve и деплоим на tomcat(настоящее java приложение)
//          и поэтому path идет от директории tomcat
//        Files.readAllBytes(Path.of("resources", "first.json"));

        try (var outputStream = resp.getOutputStream()) {
            var inputStream = DownloadServlet.class.getClassLoader().getResourceAsStream("first.json");
            outputStream.write(inputStream.readAllBytes());
        }
    }
}
