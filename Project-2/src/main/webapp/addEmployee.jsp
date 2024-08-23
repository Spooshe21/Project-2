<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    This is a JSP page for adding a new employee. It contains a form that takes
    various employee details and submits them to the EmployeeServlet for processing.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- Meta tag for specifying character encoding -->
    <meta charset="UTF-8">
    <!-- Title of the page displayed on the browser tab -->
    <title>Add Employee</title>
    <!-- Link to external CSS file for styling the form and page -->
    <link rel="stylesheet" type="text/css" href="AddStyles.css">
</head>
<body>
    <!-- Main container for the form -->
    <div class="container">
        <!-- Heading of the form -->
        <h1>Add Employee</h1>
        
        <!-- 
            Form for collecting employee details.
            The action attribute specifies the servlet to handle the form submission.
            The method="post" indicates that form data will be sent in the HTTP request body.
        -->
        <form action="EmployeeServlet?action=add" method="post">
            
            <!-- Form group for Employee ID input -->
            <div class="form-group">
                <label for="emp_id">Emp_id:</label>
                <input type="number" id="emp_id" name="emp_id" required>
                <!-- 
                    The 'required' attribute ensures that the form cannot be submitted 
                    without filling out this field.
                -->
            </div>
            
            <!-- Form group for Name input -->
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            
            <!-- Form group for Email input -->
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <!-- Form group for Address input -->
            <div class="form-group">
                <label for="address">Address:</label>
                <textarea id="address" name="address" required></textarea>
            </div>
            
            <!-- Form group for Phone input -->
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" required>
            </div>
            
            <!-- Form group for Department input -->
            <div class="form-group">
                <label for="department">Department:</label>
                <input type="text" id="department" name="department" required>
            </div>
            
            <!-- Form group for Designation input -->
            <div class="form-group">
                <label for="designation">Designation:</label>
                <input type="text" id="designation" name="designation" required>
            </div>
            
            <!-- Form group for Active status checkbox -->
            <div class="form-group">
                <label for="isActive">Active:</label>
                <input type="checkbox" id="isActive" name="isActive">
                <!-- 
                    Checkbox for indicating whether the employee is active. 
                    If checked, it will send a value of "on" when the form is submitted.
                -->
            </div>
            
            <!-- Submit button to add the employee -->
            <button type="submit" class="btn">Add Employee</button>
        </form>
    </div>
</body>
</html>
