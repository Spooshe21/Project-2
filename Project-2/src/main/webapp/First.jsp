<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    The page directive defines the attributes of this JSP page:
    - language="java": Indicates that Java is used for scripting within this JSP page.
    - contentType="text/html; charset=UTF-8": Sets the MIME type and character encoding for the HTTP response to HTML and UTF-8.
    - pageEncoding="UTF-8": Specifies the character encoding for the JSP page itself.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- 
        The meta tag specifies the character encoding for the HTML document to UTF-8.
        This ensures that characters are properly rendered in different languages.
    -->
    <meta charset="UTF-8">
    
    <!-- 
        The title tag sets the title of the page, which appears in the browser tab.
    -->
    <title>Employee Details Application</title>
    
    <!-- 
        The link tag links to an external CSS file named "Firststyles.css".
        This file contains styles that are applied to the HTML elements on this page.
    -->
    <link rel="stylesheet" type="text/css" href="Firststyles.css">
</head>
<body>
    <% 
        // Retrieve the current session, if it exists.
        HttpSession usersession = request.getSession(false);

        // Check if the session is null or if the "username" attribute is not set.
        if (usersession == null || usersession.getAttribute("username") == null) {
            // User is not logged in, so redirect to the login page.
            response.sendRedirect("login.jsp");
            return; // Stop further processing of the JSP page.
        }
    %>

    <!-- Container for the main content of the page -->
    <div class="container">
        <!-- Main heading of the page -->
        <h1>Employee Details</h1>
        
        <!-- Container for the action buttons -->
        <div class="button-container">
            <!-- Link to add a new employee -->
            <a href="EmployeeServlet?action=add" class="button">Add Employee</a>
            <!-- Link to view the list of employees -->
            <a href="EmployeeServlet?action=view" class="button">View Employees</a>
        </div>
    </div>
</body>
</html>
