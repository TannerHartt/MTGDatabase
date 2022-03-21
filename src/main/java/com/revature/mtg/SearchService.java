package com.revature.mtg;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SearchService extends HttpServlet {

    /**
     * Setting the connection information to connect to the existing database to execute more commands.
     */
    String url = "jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;";
    String username = "sa";
    String password = "";
    Connection conn;
    {
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This override method reads what the user types into the search bar and stores it as searchName with an '=' at the end and a '+' representing a space.
     * It then takes that value and removes the '=' and replaces the '+' with a space.
     * Then using a prepare statement to return the contents of the database and saves it to a String array.
     * Once the array is filled, using a for each loop it searches the array for all cards that contain the searchName in its name and
     * displays them to the web page with a href tag to display the card image.
     * Using the .toLowerCase and .contains it makes the search bar non-case sensitive and dynamic for incorrect inputs.
     *
     * @param req http request sent from the server.
     * @param resp printing/sending the response to the server to display on the webpage.
     * @throws IOException if this error occurs, it throws it back to the method that called it.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String searchName = req.getQueryString();
        String[] getVariable = searchName.split("=");
        String replacedString;
        if (getVariable.length == 1) {
            replacedString = "Black Lotus";
        } else {
            replacedString = getVariable[1].replaceAll("\\+", " ");
        }

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
                        rs.getString("ScryfallId"));
                    cards.add(cardToAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().println(
                        "<html>" +
                        "<head>" +
                        "<title>Card View</title> "+
                        "<link rel='stylesheet' href='searchPage.css'>" +
                        "<link rel='icon' href='favicon.ico'>" +
                        "</head>" +
                        "<body>"+
                        "<div class='outerContents'>" +
                        "<a href='index.html'><img class='logo' src='https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Magicthegathering-logo.svg/512px-Magicthegathering-logo.svg.png?20160501122627%3E'></a> <br><br>"+
                        "<h1><center><b>Search Results for <i>" + replacedString + "</i></b></center></h1><br><br>" +
                        "<div class='cardsToShow'> " );


        int count=0;
        for (Card stackOfCards : cards) {
            if (cards.get(count).getName().toLowerCase().contains(replacedString.toLowerCase())) {
                resp.getWriter().println("<a href='viewcard.html?scryfallId="+cards.get(count).getScryfallId()+"'><img src='https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid="+cards.get(count).getMultiverse()+"&type=card'></a>");
            }
            count++;
        }
        resp.getWriter().println(
                "</div>" +
//                        "<div class pageBottom></div>" +
                        "</body>"+
                        "</html>"
        );
    }
}
