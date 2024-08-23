<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    The page directive defines the attributes of this JSP page:
    - language="java": Specifies that Java is used for scripting within this JSP.
    - contentType="text/html; charset=UTF-8": Defines the MIME type and character encoding for the HTTP response.
    - pageEncoding="UTF-8": Specifies the character encoding used in the JSP source file.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- 
        The meta tag sets the character encoding for the HTML document to UTF-8.
        This ensures proper rendering of characters in different languages.
    -->
    <meta charset="UTF-8">
    
    <!-- 
        The title tag sets the title of the page, which is displayed in the browser tab.
    -->
    <title>Export to Excel</title>
    
    <!-- 
        The link tag links to an external CSS file named "styles.css".
        This CSS file contains styles that are applied to the HTML elements on this page.
    -->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <!-- 
        The main heading of the page, indicating the page's functionality.
    -->
    <h1>Export to Excel</h1>
    
    <!-- 
        This anchor tag creates a hyperlink that triggers the export of employee data to an Excel file.
        It invokes the 'exportToExcel' action of the EmployeeServlet when clicked.
    -->
    <a href="EmployeeServlet?action=exportToExcel">Export Employees to Excel</a>
</body>
</html>
