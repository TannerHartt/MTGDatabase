package com.revature.mtg;

import com.revature.mtg.servlets.*;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {

    public static void main(String[] args) {

        // Run server and creates mappings
        Tomcat server = new Tomcat();
        server.setBaseDir("java.io.tmpdir");
        server.setPort(8080);
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("","cardServlet", new CardServlet()).addMapping("/cards");
        server.addServlet("", "addCard", new AddCard()).addMapping("/addCard");
        server.addServlet("","allCards", new AllCards()).addMapping("/allCards");
        server.addServlet("","randomCards", new RandomCard()).addMapping("/randomCard");
        server.addServlet("","Search", new SearchService()).addMapping("/search");
        server.addServlet("","cardView", new ViewAddACard()).addMapping("/viewAdd");

        try {
            server.start();
            System.out.println("Server is running on http://localhost:" + server.getConnector().getLocalPort());
            server.getServer().await();
        } catch (LifecycleException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}
