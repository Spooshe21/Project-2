<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    This JSP page allows users to edit existing employee information.
    It displays a form pre-populated with the current details of the employee,
    which can be updated and submitted to the server for processing.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- Meta tag to define the character encoding for the document -->
    <meta charset="UTF-8">
    
    <!-- Title of the page displayed in the browser tab -->
    <title>Edit Employee</title>
    
    <!-- Link to external CSS stylesheet for styling the page -->
    <link rel="stylesheet" type="text/css" href="EditStyles.css">
    
    <!-- JavaScript function to display a confirmation dialog before submitting the form -->
    <script>
        function confirmUpdate() {
            return confirm("Are you sure you want to update this employee?");
        }
    </script>
</head>
<body>
    <!-- Main container for the edit employee form -->
    <div class="container">
        <!-- Page heading -->
        <h1>Edit Employee</h1>
        
        <!-- 
            Form to edit employee details.
            - 'action' specifies the server endpoint to handle the form submission.
            - 'method' is set to POST to securely send data.
            - 'onsubmit' triggers the confirmUpdate() function before submission.
        -->
        <form action="EmployeeServlet?action=edit" method="post" onsubmit="return confirmUpdate();">
            
            <!-- Form group for Employee ID -->
            <div class="form-group">
                <label for="emp_id">Emp_id:</label>
                <!-- 
                    Input field for employee ID.
                    - 'value' is pre-filled with the current employee ID.
                    - 'required' ensures the field is not left empty.
                    - Consider making this field readonly if the ID should not be edited.
                -->
                <input type="number" name="emp_id" value="${employee.emp_id}" required>
            </div>
            
            <!-- Form group for Name -->
            <div class="form-group">
                <label for="name">Name:</label>
                <!-- Input field for employee name -->
                <input type="text" id="name" name="name" value="${employee.name}" required>
            </div>
            
            <!-- Form group for Email -->
            <div class="form-group">
                <label for="email">Email:</label>
                <!-- Input field for employee email -->
                <input type="email" id="email" name="email" value="${employee.email}" required>
            </div>
            
            <!-- Form group for Address -->
            <div class="form-group">
                <label for="address">Address:</label>
                <!-- Input field for employee address -->
                <input type="text" id="address" name="address" value="${employee.address}" required>
            </div>
            
            <!-- Form group for Phone -->
            <div class="form-group">
                <label for="phone">Phone:</label>
                <!-- Input field for employee phone number -->
                <input type="tel" id="phone" name="phone" value="${employee.phone}" required>
            </div>
            
            <!-- Form group for Department -->
            <div class="form-group">
                <label for="department">Department:</label>
                <!-- Input field for employee department -->
                <input type="text" id="department" name="department" value="${employee.department}" required>
            </div>
            
            <!-- Form group for Designation -->
            <div class="form-group">
                <label for="designation">Designation:</label>
                <!-- Input field for employee designation -->
                <input type="text" id="designation" name="designation" value="${employee.designation}" required>
            </div>
            
            <!-- Form group for Active Status -->
            <div class="form-group">
                <label for="isActive">Active:</label>
                <!-- 
                    Checkbox to indicate if the employee is active.
                    - The 'checked' attribute is set based on the employee's current status.
                -->
                <input type="checkbox" id="isActive" name="isActive" ${employee.active ? 'checked' : ''}>
            </div>
            
            <!-- Submit button to update employee details -->
            <button type="submit" class="btn">Update Employee</button>
        </form>
    </div>
</body>
</html>
