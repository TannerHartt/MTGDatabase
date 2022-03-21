package com.revature.mtg;

import com.revature.mtg.servlets.*;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.*;


public class App {


    public static void main(String[] args) throws SQLException {

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
        server.addServlet("", "Logging", new LogPrint()).addMapping("/logs");
        server.addServlet("","Search", new SearchService()).addMapping("/search");

//        Logger logger = LoggerFactory.getLogger(App.class);
//        logger.info("This is an info level logging message");


        try {
            server.start();
            System.out.println("Server is running on http://localhost:" + server.getConnector().getLocalPort());
            server.getServer().await();
        } catch (LifecycleException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}
