<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
    <h1>Employee List</h1>
    
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
                <th>Actions</th>
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
                    <td>
                        <a href="EmployeeServlet?action=edit&emp_id=${employee.emp_id}">Edit</a> | 
                        <a href="EmployeeServlet?action=delete&emp_id=${employee.emp_id}">Delete</a>
                    </td>
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
