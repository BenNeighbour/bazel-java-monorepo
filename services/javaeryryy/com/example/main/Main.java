package com.example.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static HttpServer createServer(Injector injector) throws IOException {
        var server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/analyze", injector.getInstance(AnalyzeHandler.class));
        server.setExecutor(null);

        return server;
    }

    public static void main(String[] args) throws Exception {
        var injector = Guice.createInjector(new AppModule());
        var server = createServer(injector);

        server.start();

        System.out.println("Server running at http://localhost:8080/");
    }
}
