package com.plaxa.http.socket.clients;

import java.io.IOException;
import java.net.URL;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        var url = new URL("file:/Users/maksimplaksa/IdeaProjects/http-servlets-starter/src/com/plaxa/http/socket/udp_test/client/DatagramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkGoogle() throws IOException {
        var url = new URL("https://www.google.com");
        var urlConnection = url.openConnection();

        urlConnection.getHeaderFields();

        try (var outputStream = urlConnection.getOutputStream()) {
        }

        System.out.println();
    }
}
