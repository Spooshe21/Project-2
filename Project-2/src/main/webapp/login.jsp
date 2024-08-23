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
    <title>Login Page</title>
    
    <!-- Link to the external CSS file for styling the page -->
    <link rel="stylesheet" href="loginpage.css">
    
    <!-- JavaScript for handling alerts based on registration and login status -->
    <script>
        // Function to show an alert if registration is successful
        function showAlert() {
            alert("Registration successful! Please log in.");
        }
        
        // Function to show an alert if login is successful
        function showLoginAlert() {
            alert("Login successful! Welcome back.");
        }
    </script>
</head>
<body>
    <div class="container">
        <!-- Heading for the login page -->
        <h1>Login</h1>
        
        <!-- Display an alert if the success parameter is set to true in the request -->
        <% if ("true".equals(request.getParameter("success"))) { %>
            <script>
                // Call the alert function for successful registration
                showAlert();
            </script>
        <% } %>
        
        <!-- Display an alert if the loginSuccess parameter is set to true in the request -->
        <% if ("true".equals(request.getParameter("loginSuccess"))) { %>
            <script>
                // Call the alert function for successful login
                showLoginAlert();
            </script>
        <% } %>
        
        <!-- Form for user login -->
        <form action="login" method="POST">
            <!-- Input field for username -->
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <!-- Input field for password -->
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <!-- Submit button for the form -->
            <input type="submit" value="Login">
        </form>

        <!-- Display error message if the error attribute is present in the request -->
        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>
        
        <!-- Prompt for users without an account to sign up -->
        <p class="signup-prompt">
            Don't have an account? 
            <a href="register.jsp">Sign up</a>
        </p>
    </div>
</body>
</html>
