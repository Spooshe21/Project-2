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
    <title>Import from CSV</title>
    
    <!-- 
        The link tag links to an external CSS file named "Icsv.css".
        This file contains styles that are applied to the HTML elements on this page.
    -->
    <link rel="stylesheet" type="text/css" href="Icsv.css">
</head>
<body>
    <!-- Main heading of the page -->
    <h1>Import from CSV</h1>
    
    <!-- Form for uploading a CSV file -->
    <form action="EmployeeServlet?action=importFromCSV" method="post" enctype="multipart/form-data">
        <!-- Label for the file input field -->
        <label for="csvFile">Select CSV File:</label>
        
        <!-- File input field for selecting the CSV file -->
        <input type="file" id="csvFile" name="csvFile"><br><br>
        
        <!-- Submit button to send the form data -->
        <input type="submit" value="Import">
    </form>

</body>
</html>
