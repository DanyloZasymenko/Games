<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<link rel="stylesheet" href="css/login.css">
<!-- 
	<form:form action="loginprocesing" method="post">

		<input name="username" type="text" placeholder="login">
		<br>
		<input name="password" type="password" placeholder="password">
		<br>
		<button>login</button>

	</form:form>
-->

<div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form action="loginprocesing" method="post" class="form-signin">
            	<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <input name="username" type="text" id="inputEmail" class="form-control" placeholder="Login" required autofocus>
                <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                </div>
                <div id="button">
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
                </div>
            </form>
        </div><!-- /card-container -->
    </div><!-- /container -->
	
	


</body>
</html>