<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    The page directive specifies the following attributes:
    - language="java": Indicates that Java is used for scripting within this JSP page.
    - contentType="text/html; charset=UTF-8": Sets the MIME type and character encoding for the HTTP response to HTML and UTF-8.
    - pageEncoding="UTF-8": Specifies the character encoding for the JSP page itself.
-->

<!DOCTYPE html>
<html>
<head>
    <!-- 
        The meta tag specifies the character encoding for the HTML document.
        UTF-8 ensures that characters are rendered correctly across different languages.
    -->
    <meta charset="UTF-8">
    
    <!-- 
        The title tag sets the title of the page, which appears in the browser tab.
    -->
    <title>Import from Excel</title>
    
    <!-- 
        The link tag links to an external CSS file named "Iexcel.css".
        This file contains styles that are applied to the HTML elements on this page.
    -->
    <link rel="stylesheet" type="text/css" href="Iexcel.css">
</head>
<body>
    <!-- Main heading of the page -->
    <h1>Import from Excel</h1>
    
    <!-- Form for uploading an Excel file -->
    <form action="EmployeeServlet?action=importFromExcel" method="post" enctype="multipart/form-data">
        <!-- Label for the file input field -->
        <label for="excelFile">Select Excel File:</label>
        
        <!-- File input field for selecting the Excel file -->
        <input type="file" id="excelFile" name="excelFile"><br><br>
        
        <!-- Submit button to send the form data -->
        <input type="submit" value="Import">
    </form>

</body>
</html>
