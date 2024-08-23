<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    The page directive specifies:
    - language="java": The scripting language used in this JSP page.
    - contentType="text/html; charset=UTF-8": The content type and character encoding for the HTTP response.
    - pageEncoding="UTF-8": The encoding for the JSP page itself.
-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 
    Taglib directive declares the JSTL core library with the prefix "c", 
    which is used for JSP Standard Tag Library (JSTL) core tags.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- Specifies the character encoding for the HTML document -->
    <meta charset="UTF-8">
    
    <!-- Title of the web page, shown in the browser tab -->
    <title>View Employees</title>
    
    <!-- Link to the external CSS file for styling the page -->
    <link rel="stylesheet" type="text/css" href="ViewStyles.css">
    
    <!-- JavaScript function to display an alert message -->
    <script>
        function showAlert(message) {
            alert(message);
        }
    </script>
</head>
<body>
    <!-- Main container for the page content -->
    <div class="container">
        <!-- Main heading for the employee view page -->
        <h1>View Employees</h1>
        
        <!-- Conditional statement to show an alert if the "message" attribute is present -->
        <c:if test="${not empty message}">
            <script>
                showAlert('${message}');
            </script>
        </c:if>

        <!-- Table and Button Container -->
        <div class="table-and-buttons">
            <!-- Table displaying employee details -->
            <table>
                <thead>
                    <tr>
                        <th>Emp_id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Department</th>
                        <th>Designation</th>
                        <th>Active</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through the list of employees and display each one in a table row -->
                    <c:forEach items="${employees}" var="employee">
                        <tr>
                            <td>${employee.emp_id}</td>
                            <td>${employee.name}</td>
                            <td>${employee.email}</td>
                            <td>${employee.address}</td>
                            <td>${employee.phone}</td>
                            <td>${employee.department}</td>
                            <td>${employee.designation}</td>
                            <td>${employee.active}</td>
                            <td>
                                <!-- Link to edit an employee's details -->
                                <a href="EmployeeServlet?action=edit&emp_id=${employee.emp_id}" class="btn btn-edit">Edit</a>
                            </td>
                            <td>
                                <!-- Link to delete an employee -->
                                <a href="EmployeeServlet?action=delete&emp_id=${employee.emp_id}" class="btn btn-delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Container for action buttons -->
            <div class="button-container">
                <!-- Links to perform various actions related to employee management -->
                <a href="EmployeeServlet?action=add" class="btn btn-add">Add Employee</a>
                <a href="EmployeeServlet?action=exportToExcel" class="btn btn-export">Export to Excel</a>
                <a href="EmployeeServlet?action=exportToCSV" class="btn btn-export">Export to CSV</a>
                <a href="EmployeeServlet?action=importFromExcel" class="btn btn-import">Import from Excel</a>
                <a href="EmployeeServlet?action=importFromCSV" class="btn btn-import">Import from CSV</a>
            </div>
        </div>

        <!-- Logout button -->
        <a href="logout" class="logout-btn">Logout</a>
    </div>
</body>
</html>
