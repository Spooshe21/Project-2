<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Confirm Delete Employee</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
    <h1>Confirm Delete Employee</h1>
    
    <p>Are you sure you want to delete the following employee?</p>
    
    <table>
        <tr>
            <th>Employee ID</th>
            <td>${employee.emp_id}</td>
        </tr>
        <tr>
            <th>First Name</th>
            <td>${employee.firstName}</td>
        </tr>
        <tr>
            <th>Last Name</th>
            <td>${employee.lastName}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${employee.email}</td>
        </tr>
        <tr>
            <th>Phone</th>
            <td>${employee.phone}</td>
        </tr>
        <tr>
            <th>Hire Date</th>
            <td>${employee.hireDate}</td>
        </tr>
        <tr>
            <th>Job Title</th>
            <td>${employee.jobTitle}</td>
        </tr>
        <tr>
            <th>Department</th>
            <td>${employee.department}</td>
        </tr>
        <tr>
            <th>Salary</th>
            <td>${employee.salary}</td>
        </tr>
    </table>
    
    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="emp_id" value="${employee.emp_id}">
        <input type="submit" value="Confirm Delete">
    </form>
    
    <a href="EmployeeServlet?action=list">Cancel</a>

    <c:catch var="exception">
        <c:out value="${exception.message}"/>
    </c:catch>
</body>
</html>
