//package com.revature.mtg;
//
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
//
//
//public class Server {
// public Server() {
//    // Run server
//        Tomcat server = new Tomcat();
//        server.setBaseDir("java.io.tmpdir");
//        server.setPort(8080);
//        server.getConnector();
//        server.addContext("", null);
//        server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");
//        server.addServlet("","cardServlet", new CardServlet()).addMapping("/cards");
//
//        try {
//            server.start();
//            System.out.println("Server is running on http://localhost:" + server.getConnector().getLocalPort() + "/addCard.html");
//            server.getServer().await();
//        } catch (LifecycleException e) {
//        System.err.println("Failed to start server: " + e.getMessage());
//        }
//    }
//}