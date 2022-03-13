package com.revature.mtg;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;

//public class Server {
//    public void Server() {
//
//    // Run server
//    Tomcat server = new Tomcat();
//        server.setPort(8080);
//        server.getConnector();
//        server.addContext("", null);
//        server.addServlet("", "defaultServlet", new HttpServlet() {
//        @Override
//        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
//        {
//            String filename = req.getPathInfo();
//            String resourceDir = "static";
//            InputStream file = getClass().getClassLoader().getResourceAsStream(resourceDir + filename);
//            if(filename.equals("")) filename = "static/index.html";
//            if (file == null) {
//                filename = "static/index.html";
//            } else {
//                String mimeType = getServletContext().getMimeType(filename);
//                resp.setContentType(mimeType);
//                IOUtils.copy(file, resp.getOutputStream());
//            }
//        }
//    }).addMapping("/*");
//        server.addServlet("","cardServlet", cardServlet).addMapping("/cards");
//
//        try {
//        server.start();
//        System.out.println("Server is running on http://localhost:" + server.getConnector().getLocalPort() + "/cards");
//        server.getServer().await();
//    } catch (
//    LifecycleException e) {
//        System.err.println("Failed to start server: " + e.getMessage());
//    }
//        server.getServer().await();
//    }
//}

