package com.revature.mtg;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardServlet extends HttpServlet {

    // H2 connection information:
    String url = "jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:schema.sql'";
    String username = "sa";
    String password = "";

    // Postgres connection info

    //String url = "jdbc:postgresql//localhost:5432/postgres";
    //String username = "sa";
    //String password = "";

    Connection conn;
    {
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Card> cards = new ArrayList<>();
        try {
            ResultSet rs = conn.prepareStatement("select * from cards").executeQuery();
            while (rs.next()) {
                Card cardToAdd = new Card(rs.getInt("TypeId"),rs.getInt("ManaCost"),rs.getString("Name"));
                cards.add(cardToAdd);
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
            PreparedStatement stmt = conn.prepareStatement("insert into cards values (?,?,?)");
            stmt.setInt(1, newCard.getTypeId());
            stmt.setInt(2, newCard.getCost());
            stmt.setString(3, newCard.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert: " + e.getMessage());
        }
    }
}
