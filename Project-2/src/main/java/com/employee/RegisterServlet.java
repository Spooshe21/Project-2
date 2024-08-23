/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  RegisterServlet.java file
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
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class RegisterServlet
 * 
 * This servlet handles user registration. It processes form data from the registration page,
 * performs basic validation, and inserts the user data into a PostgreSQL database. After a successful
 * registration, it redirects the user to the login page; otherwise, it forwards the user back to the
 * registration page with an error message.
 */

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles POST requests for user registration.
     * 
     * This method retrieves user input from the registration form, validates the input, and inserts
     * the user data into the database. If the passwords do not match or if there is a database error,
     * it forwards the user back to the registration page with an appropriate error message.
     * 
     * @param request  HttpServletRequest object used to retrieve form data and session attributes.
     * @param response HttpServletResponse object used to redirect or forward the user based on the result.
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException      If an error occurs during response handling.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");

        // Validate if the passwords match
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        try {
            // Establish a connection to the PostgreSQL database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "Crevavi");
            
            // SQL query to insert a new user into the database
            String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password); // Password should be hashed in a real application
            statement.setString(3, email);
            
            // Execute the SQL query
            statement.executeUpdate();
            connection.close();
            
            // Redirect to the login page with a success message
            response.sendRedirect("login.jsp?success=true");
        } catch (Exception e) {
            // Log the exception and forward to registration page with an error message
            e.printStackTrace();
            request.setAttribute("error", "Registration failed. Username may already exist.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
