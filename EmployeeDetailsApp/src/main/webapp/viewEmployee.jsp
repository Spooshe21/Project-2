<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
    <h1>Employee Details</h1>
    
    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="insert">
        <div class="form-group">
            <label for="emp_id">Employee ID:</label>
            <input type="text" id="emp_id" name="emp_id" required placeholder="Enter Employee ID">
        </div>
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required placeholder="Enter First Name">
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required placeholder="Enter Last Name">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required placeholder="Enter Email">
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required placeholder="Enter Phone Number">
        </div>
        <div class="form-group">
            <label for="hireDate">Hire Date:</label>
            <input type="date" id="hireDate" name="hireDate" required>
        </div>
        <div class="form-group">
            <label for="jobTitle">Job Title:</label>
            <input type="text" id="jobTitle" name="jobTitle" required placeholder="Enter Job Title">
        </div>
        <div class="form-group">
            <label for="department">Department:</label>
            <input type="text" id="department" name="department" required placeholder="Enter Department">
        </div>
        <div class="form-group">
            <label for="salary">Salary:</label>
            <input type="number" id="salary" name="salary" required placeholder="Enter Salary">
        </div>
        <input type="submit" value="Add Employee">
    </form>
    
    <c:if test="${not empty employees}">
        <table>
            <tr>
                <th>Employee ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Hire Date</th>
                <th>Job Title</th>
                <th>Department</th>
                <th>Salary</th>
            </tr>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.emp_id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.email}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.hireDate}</td>
                    <td>${employee.jobTitle}</td>
                    <td>${employee.department}</td>
                    <td>${employee.salary}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty employees}">
        <p>No employees available.</p>
    </c:if>
    
    <c:catch var="exception">
        <c:out value="${exception.message}"/>
    </c:catch>
</body>
</html>
