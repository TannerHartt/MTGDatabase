package com.revature.mtg;

import com.revature.mtg.servlets.CardServlet;
import com.revature.mtg.servlets.DefaultServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import java.sql.*;


public class App {

    public static void main(String[] args) throws SQLException {

        // Run server and added mappings
        Tomcat server = new Tomcat();
        server.setBaseDir("java.io.tmpdir");
        server.setPort(8080);
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet("","cardServlet", new CardServlet()).addMapping("/cards");

        try {
            server.start();
            System.out.println("Server is running on http://localhost:" + server.getConnector().getLocalPort() + "/index.html");
            server.getServer().await();
        } catch (LifecycleException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}



