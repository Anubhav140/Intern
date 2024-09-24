<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <div id="main">
        <div id="images">
            <img src="./img/Logo.jpg" alt="" class="center">
        </div>
        <div id="yellow">
        </div>
        <div id="wel">
            <h6>Welcome to PNB Litigation Management System</h6>
        </div>
        <div id="log">
            <div id="form">
                <h6>User login</h6>
                <form action="<%=request.getContextPath() %>/Controller" method="post">
                    <label for="employeeid">Employee ID:* </label>
                    <input type="text" id="employeeid" name="employeeid" required><br><br>
                    <label for="password">Password:* </label>
                    <input type="password" id="password" name="password" required style="margin-left: 74px;"><br><br>
                    <input type="submit" value="Log In" style="width: 20%; height: 40px; margin-top: 15%; background-color: #fbbc09; margin-left: 160px; margin-top: 130px; font-size: medium;">
                </form>
            </div>
            <div id="lms">
                <img src="./img/Litigation-Document-Management-Software-1.webp" alt="">
            </div>
        </div>
    </div>
    <footer>
        <ul class="horizontal-list text-center">
            <li style="color: black;">@2024 Punjab National Bank</li>
            <li><a href="https://www.pnbindia.in/Terms-of-use.html">Terms and Conditions</a></li>
            <li><a href="https://www.pnbindia.in/privacypolicy.html">Privacy Policy</a></li>
            <li><a href="https://www.pnbindia.in/disclaimer.html">Disclaimer </a></li>
            <li><a href="">Security Information</a></li>
            <li><a href="mailto:anubhavsharma04042003@gmail.com">Trouble logging in</a></li>
        </ul>
    </footer>
</body>
</html>