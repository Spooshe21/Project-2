<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    This is a JSP page for confirming the deletion of an employee. 
    It displays the employee's name and asks the user to confirm or cancel the deletion.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- Meta tag for specifying character encoding -->
    <meta charset="UTF-8">
    <!-- Title of the page displayed on the browser tab -->
    <title>Delete Employee</title>
    <!-- Link to external CSS file for styling the form and page -->
    <link rel="stylesheet" type="text/css" href="DeleteStyles.css">
    
    <!-- JavaScript function to show an alert when the cancel button is clicked -->
    <script>
        function showCancelAlert() {
            alert("Oops! Canceled.");
        }
    </script>
</head>
<body>
    <!-- Main container for the deletion confirmation form -->
    <div class="container">
        <!-- Heading of the form -->
        <h1>Delete Employee</h1>
        
        <!-- 
            Message confirming the deletion, dynamically displaying the employee's name 
            using JSP expression language.
        -->
        <p>Are you sure you want to delete the employee <strong>${employee.name}</strong>?</p>
        
        <!-- 
            Form for submitting the deletion request.
            The action attribute specifies the servlet to handle the deletion.
            The method="post" indicates that form data will be sent in the HTTP request body.
        -->
        <form action="EmployeeServlet?action=delete" method="post">
            <!-- Hidden field to pass the employee's ID to the servlet -->
            <input type="hidden" name="emp_id" value="${employee.emp_id}">
            
            <!-- Button to confirm the deletion -->
            <button type="submit" class="btn delete">Yes, Delete</button>
            
            <!-- 
                Link to cancel the deletion and return to the employee view.
                The onclick event triggers the showCancelAlert function, and return false 
                prevents the link from navigating away from the page.
            -->
            <a href="EmployeeServlet?action=view" class="btn cancel" onclick="showCancelAlert(); return false;">No, Cancel</a>
        </form>
    </div>
</body>
</html>
