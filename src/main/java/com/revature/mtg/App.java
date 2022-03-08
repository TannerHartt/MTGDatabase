package com.revature.mtg;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {
        // Connect to DB
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:schema.sql'", "sa", "");
        ResultSet rs = conn.prepareStatement("select * from cards").executeQuery();
        List<String> cards = new ArrayList<>();
        while (rs.next()) {
            cards.add(rs.getString("Name"));
        }


        HttpServlet cardServlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                List<Card> cards = new ArrayList<>();
                try {
                    ResultSet rs = conn.prepareStatement("select * from cards").executeQuery();
                    while (rs.next()) {
                        cards.add(new Card(rs.getString("Name"), rs.getInt("TypeId"), rs.getInt("Cost")));
                    }
                } catch (SQLException e) {
                    System.err.println("Failed to retrieve from database: " + e.getSQLState());
                }
                // Get JSON mapper
                ObjectMapper mapper = new ObjectMapper();
                String results = mapper.writeValueAsString(cards);
                resp.setContentType("application/json");
                resp.getWriter().println(results);
            }
            @Override
            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                ObjectMapper mapper = new ObjectMapper();
                Card newCard = mapper.readValue(req.getInputStream(), Card.class);
                try {
                    PreparedStatement stmt = conn.prepareStatement("insert into 'cards' values (?,?)");
                    stmt.setInt(1, newCard.getTypeId());
                    stmt.setString(2, newCard.getName());
                    stmt.setInt(3, newCard.getCost());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Failed to insert: " + e.getMessage());
                }
            }
        };


        // Run server
        Tomcat server = new Tomcat();
        server.setPort(8080);
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "defaultServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String filename = req.getPathInfo();
                String resourceDir = "static";
                InputStream file = getClass().getClassLoader().getResourceAsStream(resourceDir + filename);
                String mimeType = getServletContext().getMimeType(filename);
                resp.setContentType(mimeType);
                IOUtils.copy(file, resp.getOutputStream());
            }
        }).addMapping("/*");
        server.addServlet("","cardServlet", cardServlet).addMapping("/cards");

        try {
            server.start();
            System.out.println("Server is running on http://localhost:" + server.getConnector().getLocalPort() + "/cards");
            server.getServer().await();
        } catch (LifecycleException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
        server.getServer().await();
    }
}




