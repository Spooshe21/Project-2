<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    The page directive specifies:
    - language="java": The scripting language used in this JSP page.
    - contentType="text/html; charset=UTF-8": The content type and character encoding for the HTTP response.
    - pageEncoding="UTF-8": The encoding for the JSP page itself.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- Specifies the character encoding for the HTML document -->
    <meta charset="UTF-8">
    
    <!-- Title of the web page, shown in the browser tab -->
    <title>Crevavi Website</title>
    
    <!-- Link to the external CSS file for styling the page -->
    <link rel="stylesheet" href="Register.css"> <!-- Link to your CSS file -->
</head>
<body>
    <!-- Main heading for the registration page -->
    <h1>Employee Registration</h1>
    
    <!-- Form for user registration -->
    <form action="register" method="POST">
        <!-- Input field for username -->
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <!-- Input field for password -->
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <!-- Input field for confirming password -->
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>

        <!-- Input field for email -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <!-- Submit button for the form -->
        <input type="submit" value="Register">
    </form>
    
    <!-- Display error message if the error attribute is present in the request -->
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    
    <!-- Prompt for users who already have an account to log in -->
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>
