package com.revature.mtg.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mtg.Card;
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

    // Postgres' connection info:
    //String url = "jdbc:postgresql//localhost:5432/postgres";
    //String username = "postgres";
    //String password = "postgres";

    Connection conn;
    {
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Servlet set up to display the contents of the database to the server. Prints and sets content type as raw JSON data.
     * @param req http request sent from the server.
     * @param resp printing/sending the response to the server to display on the webpage.
     * @throws IOException if this error occurs, it throws it back to the method that called it.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Card> cards = new ArrayList<>();
        try {
            ResultSet rs = conn.prepareStatement("select * from cards").executeQuery();
            while (rs.next()) {
                Card cardToAdd = new Card(
                        rs.getInt("CardId"),
                        rs.getInt("TypeId"),
                        rs.getString("ManaCost"),
                        rs.getString("Name"),
                        rs.getString("Artist"),
                        rs.getString("ColorIdentity"),
                        rs.getLong("Multiverse"),
                        rs.getString("Rarity"),
                        rs.getString("scryfallId"));
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

    /**
     * Servlet set up to display the contents of the database to the server. Prints and sets content type as raw JSON data.
     * @param req http request sent from the server.
     * @param resp printing/sending the response to the server to display on the webpage.
     * @throws IOException if this error occurs, it throws it back to the method that called it.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Card newCard = mapper.readValue(req.getInputStream(), Card.class);
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into cards values (?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, newCard.getCardId());
            stmt.setInt(2, newCard.getTypeId());
            stmt.setString(3, newCard.getCost());
            stmt.setString(4, newCard.getName());
            stmt.setString(5, newCard.getArtist());
            stmt.setString(6, newCard.getColorIdentity());
            stmt.setLong(7, newCard.getMultiverse());
            stmt.setString(8, newCard.getRarity());
            stmt.setString(9, newCard.getScryfallId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert: " + e.getMessage());
        }
    }
}
