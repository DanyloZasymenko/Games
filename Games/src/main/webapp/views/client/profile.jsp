<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<script src="js/profile.js"></script>

${clientDTO.name} ${clientDTO.email}
<br>
<img src="${clientDTO.pathImage}" alt="add photo" width="200px"
	height="200px">
<br>

<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data">

	<input type="file" name="image">
	<button>save image</button>

</form:form>
<br>
your games
<br>
<br>
<c:forEach var="game" items="${listGames}">

	${game.name} ${game.year} <!-- <a href="playGame/${game.id}">play</a> <a href="deleteGameFromClient/${game.id}">delete</a> -->
	<br>

</c:forEach>
<br>
