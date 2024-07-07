<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
    <h1>Edit Employee</h1>
    
    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="emp_id" value="${employee.emp_id}">
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" value="${employee.firstName}" required>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" value="${employee.lastName}" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${employee.email}" required>
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" value="${employee.phone}" required>
        </div>
        <div class="form-group">
            <label for="hireDate">Hire Date:</label>
            <input type="date" id="hireDate" name="hireDate" value="${employee.hireDate}" required>
        </div>
        <div class="form-group">
            <label for="jobTitle">Job Title:</label>
            <input type="text" id="jobTitle" name="jobTitle" value="${employee.jobTitle}" required>
        </div>
        <div class="form-group">
            <label for="department">Department:</label>
            <input type="text" id="department" name="department" value="${employee.department}" required>
        </div>
        <div class="form-group">
            <label for="salary">Salary:</label>
            <input type="number" id="salary" name="salary" value="${employee.salary}" required>
        </div>
        <input type="submit" value="Update Employee">
    </form>

    <c:catch var="exception">
        <c:out value="${exception.message}"/>
    </c:catch>
</body>
</html>
