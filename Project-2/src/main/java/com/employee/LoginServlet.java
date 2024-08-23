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


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "Crevavi");
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String storedPassword = resultSet.getString("password");
				if (password.equals(storedPassword)) {
					HttpSession session = request.getSession(); // Create or get the session
                    session.setAttribute("username", username); // Store user information in the session

                    // Redirect to the home page after successful login
                    response.sendRedirect("First.jsp?loginSuccess=true");
					
				} else {
					// Invalid password, display error message
					request.setAttribute("error", "Invalid username or password.");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} else {
				// User not found, display error message
				request.setAttribute("error", "User not found!.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


