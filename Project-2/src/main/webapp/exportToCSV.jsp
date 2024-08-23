<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    The page directive defines the attributes of this JSP page:
    - language="java": Specifies that Java is used for scripting.
    - contentType="text/html; charset=UTF-8": Defines the content type and character encoding for the response.
    - pageEncoding="UTF-8": Sets the character encoding for the JSP page itself.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- 
        The meta tag specifies the character encoding for the HTML document.
        UTF-8 ensures that a wide range of characters is supported and displayed correctly.
    -->
    <meta charset="UTF-8">
    
    <!-- 
        The title tag sets the title of the page, which appears on the browser tab.
    -->
    <title>Export to CSV</title>
    
    <!-- 
        This link tag connects the HTML page to an external CSS file named "styles.css".
        This file is used to apply styles to the page elements.
    -->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <!-- 
        The main heading of the page, which indicates the purpose of the page.
    -->
    <h1>Export to CSV</h1>
    
    <!-- 
        This anchor tag creates a hyperlink that allows users to export employee data to a CSV file.
        The link triggers the 'exportToCSV' action of the EmployeeServlet.
    -->
    <a href="EmployeeServlet?action=exportToCSV">Export Employees to CSV</a>
</body>
</html>
