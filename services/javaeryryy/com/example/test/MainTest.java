//package com.example.test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.example.main.AppModule;
//import com.example.main.Main;
//import com.google.inject.Guice;
//import com.sun.net.httpserver.HttpServer;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
//import org.junit.jupiter.api.Test;
//
//@RunWith(JUnitPlatform.class)
//public class MainTest {
//
//    @Test
//    public void serverIsConfiguredCorrectly() throws Exception {
//        var injector = Guice.createInjector(new AppModule());
//        HttpServer server = Main.createServer(injector);
//
//        assertEquals(8080, server.getAddress().getPort());
////        assertTrue(server.getHttpContexts().stream()
////                .anyMatch(ctx -> "/analyze".equals(ctx.getPath())));
//    }
//}
