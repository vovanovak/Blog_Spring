<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
	
	<head>
		<title>Blogger</title>
		<link rel="stylesheet" type="text/css" href="styles/signin.style.css">
		
		<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
		<script src="scripts/signin.script.js">

		</script>
	</head>
	
	<body onload="bodyOnload()">
		<main id="divMainForm" align="center">
			<h1 id="title">Blogger</h1>
			<form th:action="@{/signin}" th:object="${user}" method="post">
				<input th:field="*{username}" id="textInputUsername" class="textInput" type="text" name="Username" required placeholder="Enter your username"/><br>
				<input th:field="*{password}" id="textInputPassword" class="textInput" type="password" name="Password" required placeholder="Enter your password"/><br>
				<input id="buttonSubmit" type="submit" value="Sign In"/>
			</form>
		</main>
		<footer id='footer'>
			<a href="/blog/register" style="color: white; text-decoration:none;"><div id="buttonRegister">Register</div></a>
		</footer>
		
	</body>
</html>


