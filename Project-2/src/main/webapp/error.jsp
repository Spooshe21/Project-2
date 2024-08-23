<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Error</h1>
    <p>
        <strong>Error Message:</strong> 
        <c:out value="${param.message}" />
    </p>
    <a href="EmployeeServlet?action=view">Go Back to Employee List</a>
</body>
</html>
