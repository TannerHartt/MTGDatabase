package com.revature.mtg.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class DefaultServlet extends HttpServlet {

    /**
     * Default servlet set up to redirect any incorrect input to the index.html file, regardless of input.
     * @param req http request sent from the server. This includes switching files, adding data, or navigating menus.
     * @param resp printing the response to the server.
     * @throws IOException if this error occurs, it throws it back to the method that called it.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String filename = req.getPathInfo();
        String resourceDir = "static";
        if (filename == null || filename.equals("/") || filename.equals("")) filename = "/index.html";
        InputStream file = getClass().getClassLoader().getResourceAsStream(resourceDir + filename);
        if (file == null) {
            file = getClass().getClassLoader().getResourceAsStream(resourceDir + "/index.html");
        }
        String mimeType = getServletContext().getMimeType(filename);
        resp.setContentType(mimeType);
        IOUtils.copy(file, resp.getOutputStream());
    }
}
