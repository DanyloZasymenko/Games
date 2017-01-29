<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<h2>New Genre</h2>

<c:forEach var="genre" items="${genreDTOs}">
	<div>
		${genre.name} <a href="deleteGenre/${genre.id}">delete</a>
	</div>
</c:forEach>

<br>

<form:form modelAttribute="genreDTO" action="saveGenre" method="post">

	<div style="text-align: center; color: red; margin: 5px">
		<label for="Name">${genreException}</label>
	</div>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

	<input name="name" type="text" placeholder="insert genre here">
	<br>
	<button>save Genre</button>
</form:form>
<br>
<br>
<a href="newGame">new Game</a>
<br>
<a href="newDeveloper">new Developer</a>
<br>
<a href="newOffer">new Offer</a>