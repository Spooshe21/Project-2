/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  LogoutServlet.java file
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

/**
 * Servlet implementation class LogoutServlet
 * 
 * This servlet handles the user logout process. It invalidates the current user session and redirects
 * the user to the home page or login page. This ensures that user-specific data is cleared and the user
 * is no longer authenticated.
 */

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles GET requests for user logout.
     * 
     * This method retrieves the current session, if it exists, and invalidates it. After invalidating
     * the session, it redirects the user to the home page or login page. This process ensures that the
     * user is logged out and no session data remains.
     * 
     * @param request  HttpServletRequest object used to retrieve session information.
     * @param response HttpServletResponse object used to redirect the user.
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException      If an error occurs during response handling.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the current session, if it exists
        HttpSession session = request.getSession(false);
        
        // Invalidate the session if it is not null
        if (session != null) {
            session.invalidate();
        }

        // Redirect the user to the home page or login page after logout
        response.sendRedirect("index.jsp");
    }
}
