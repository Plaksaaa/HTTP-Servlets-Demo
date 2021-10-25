package com.plaxa.http.socket.single_threaded_http_server.runner;

import com.plaxa.http.socket.single_threaded_http_server.http_server.HttpServer;

public class HttpServerRunner {
    public static void main(String[] args) {
        var httpServer = new HttpServer(9000, 100);
        httpServer.run();
    }
}
