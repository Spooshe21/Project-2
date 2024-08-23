<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
    The page directive is used to define page-level attributes like the scripting language (Java), 
    the content type of the response (text/html), and the character encoding (UTF-8).
    This ensures that the page is correctly displayed with the appropriate language and encoding.
-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 
    This taglib directive imports the JSP Standard Tag Library (JSTL) core library.
    The 'c' prefix allows you to use JSTL core tags in this JSP page.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- 
        The meta tag specifies the character encoding for the HTML document.
        Using UTF-8 ensures that the page can correctly display a wide range of characters.
    -->
    <meta charset="UTF-8">
    
    <!-- 
        The title tag sets the title of the webpage, which is displayed on the browser tab.
    -->
    <title>Error</title>
    
    <!-- 
        This link tag connects the HTML page to an external CSS file named "styles.css".
        The stylesheet will be used to style the contents of this page.
    -->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <!-- 
        The main heading of the page, indicating that an error has occurred.
    -->
    <h1>Error</h1>
    
    <!-- 
        This paragraph displays the error message.
        The <c:out> tag is used to safely output the error message from the request parameter 'message'.
        This tag ensures that any special characters in the error message are properly escaped to prevent XSS attacks.
    -->
    <p>
        <strong>Error Message:</strong> 
        <c:out value="${param.message}"/>
    </p>
    
    <!-- 
        This anchor tag creates a hyperlink that directs the user back to the Employee List page.
        The link triggers the 'view' action of the EmployeeServlet, effectively navigating the user to the list of employees.
    -->
    <a href="EmployeeServlet?action=view">Go Back to Employee List</a>
</body>
</html>
