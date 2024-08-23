/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  LoginServlet.java file
 *   Project:  Employee Management System
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:  	   Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/

package com.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 * 
 * This servlet handles the login process for the employee management system. It verifies user credentials
 * against the database and manages user sessions upon successful authentication.
 */

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles POST requests for user login.
     * 
     * This method retrieves user credentials from the request, validates them against the database, 
     * and manages user sessions based on the authentication outcome. If authentication is successful,
     * the user is redirected to the home page. Otherwise, an error message is displayed on the login page.
     * 
     * @param request  HttpServletRequest object containing user credentials.
     * @param response HttpServletResponse object used to redirect or forward the response.
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException      If an error occurs during response handling.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user credentials from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Establish a connection to the PostgreSQL database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "Crevavi");
            
            // Prepare a SQL statement to select the user with the provided username
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            
            // Execute the query and obtain the result set
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set contains a matching user
            if (resultSet.next()) {
                // Retrieve the stored password from the database
                String storedPassword = resultSet.getString("password");
                
                // Validate the provided password against the stored password
                if (password.equals(storedPassword)) {
                    // Password is correct; create or retrieve the session
                    HttpSession session = request.getSession();
                    
                    // Store the username in the session for further use
                    session.setAttribute("username", username);
                    
                    // Redirect to the home page with a success message
                    response.sendRedirect("First.jsp?loginSuccess=true");
                } else {
                    // Password is incorrect; set an error message and forward to the login page
                    request.setAttribute("error", "Invalid username or password.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                // User not found; set an error message and forward to the login page
                request.setAttribute("error", "User not found!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            // Close the database connection
            connection.close();
        } catch (Exception e) {
            // Print stack trace in case of an exception
            e.printStackTrace();
        }
    }
}
