<%-- 
    Document   : register
    Created on : 14.09.2014, 19:05:37
    Author     : Vova
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
	<head>
            <title>Blogger</title>
            <link rel="stylesheet" type="text/css" href="styles/register.style.css">
            <script src="http://code.jquery.com/jquery-2.1.1.js"></script>
            <script src="scripts/register.script.js"></script>
	</head>
	
	<body onload="bodyOnload()"> 
		<main id="divRegForm" align="center" >
                        <span id="errormsg">${errormsg}</span>
			<h1 id="title">Blogger</h1>
                        
			<form th:action="@{/register}" th:object="${user}" method="post">
                            <input id="textInputUsername" th:field="*{username}" class="textInput" type="text"  name="Username" required placeholder="Enter your username" /><br>
                            <input class="textInput" th:field="*{password}" type="password" name="Password" required placeholder="Enter your password" /><br>
                            <input class="textInput" id="textInputDateOfBirth" th:field="*{email}" type="email" name="Email" required placeholder="Enter your email" /><br>
                     
                            <input id="buttonSubmit" type="submit" value="Register" /><br>
			</form>
		</main>
                            
                <footer id='footer'>
			<a href="/blog/signin" style="color: white; text-decoration:none;"><div id="buttonRegister">Sign In</div></a>
		</footer>
	</body>
	
</html>
