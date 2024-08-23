<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    The page directive specifies:
    - language="java": The scripting language used in this JSP page.
    - contentType="text/html; charset=UTF-8": The content type and character encoding for the HTTP response.
    - pageEncoding="UTF-8": The encoding for the JSP page itself.
-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 
    The taglib directive imports the JSTL core library, allowing the use of JSTL tags with the prefix "c".
-->

<!DOCTYPE html>
<html>
<head>
    <!-- Specifies the character encoding for the HTML document -->
    <meta charset="UTF-8">
    <!-- Ensures the page is responsive and properly scaled on different devices -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Title of the web page, shown in the browser tab -->
    <title>Home - Employee Management</title>
    
    <!-- Link to the external CSS file for styling the page -->
    <link rel="stylesheet" href="homePage.css">
    
    <!-- Link to Google Fonts for custom font styles -->
    <link href="https://fonts.googleapis.com/css2?family=Libre+Bodoni:ital,wght@0,400..700;1,400..700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Header section containing navigation links -->
    <header>
        <nav>
            <div class="logo">
                <!-- Logo image for the website -->
                <img src="images/logo-Crevavi-White.png" alt="Employee Management Logo">
            </div>
            <ul>
                <!-- Navigation links -->
                <li><a href="index.jsp">Home</a></li>
                <li><a href="register.jsp">Sign Up</a></li>
                <li><a href="login.jsp">Login</a></li>
                
                <!-- Logout link shown only if the user is logged in -->
                <c:if test="${not empty sessionScope.username}">
                    <li><a href="logout">Logout</a></li>
                </c:if>
            </ul>
        </nav>
    </header>

    <!-- Main content area -->
    <main>
        <!-- Slideshow section -->
        <section>
            <div class="slideshow-container">
                <!-- Individual slides in the slideshow -->
                <div class="slide">
                    <img src="images/Banner-01.webp" alt="Employee Management 1">
                    <div class="text-overlay">Create, Embed and Empower</div>
                </div>
                <div class="slide">
                    <img src="images/Banner-02.webp" alt="Employee Management 2">
                    <div class="text-overlay">Create, Embed and Empower</div>
                </div>
                <div class="slide">
                    <img src="images/Banner-03.webp" alt="Employee Management 3">
                    <div class="text-overlay">Create, Embed and Empower</div>
                </div>
                <div class="slide">
                    <img src="images/Banner-04.webp" alt="Employee Management 4">
                    <div class="text-overlay">Create, Embed and Empower</div>
                </div>
                <div class="slide">
                    <img src="images/Banner-05.webp" alt="Employee Management 5">
                    <div class="text-overlay">Create, Embed and Empower</div>
                </div>
                <div class="slide">
                    <img src="images/Banner-06.webp" alt="Employee Management 6">
                    <div class="text-overlay">Create, Embed and Empower</div>
                </div>
            </div>
        </section>

        <!-- Features section -->
        <section class="features">
            <h2>Key Features</h2>
            <ul>
                <!-- List of key features offered by the application -->
                <li>Add, view, edit, and delete employees</li>
                <li>Import and export employee data</li>
                <li>Secure login and registration</li>
                <li>Responsive design for any device</li>
            </ul>
        </section>
    </main>

    <!-- Footer section -->
    <footer>
        <!-- Copyright notice -->
        <p>&copy; 2024 Employee Management. All rights reserved.</p>
    </footer>
    
    <!-- JavaScript to handle the slideshow functionality -->
    <script>
        let currentIndex = 0;
        const slides = document.querySelectorAll('.slide');

        // Function to show a specific slide
        function showSlide(index) {
            slides.forEach((slide, i) => {
                slide.classList.remove('active');
                if (i === index) {
                    slide.classList.add('active');
                }
            });
        }

        // Function to move to the next slide
        function nextSlide() {
            currentIndex = (currentIndex + 1) % slides.length;
            showSlide(currentIndex);
        }

        // Show the first slide initially
        showSlide(currentIndex);

        // Change slide every 3 seconds
        setInterval(nextSlide, 3000);
    </script>
</body>
</html>
