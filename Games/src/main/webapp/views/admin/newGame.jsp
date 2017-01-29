<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h2>New Game</h2>

<c:forEach var="game" items="${gameDTOs}">
	<div>
		${game.name} ${game.year} <a href="deleteGame/${game.id}">delete</a> <br>
	</div>

</c:forEach>

<br>

<form:form modelAttribute="gameDTO" action="saveGame" method="post">

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

	<div style="text-align: center; color: red; margin: 5px">
		<label for="Name">${gameException}</label>
	</div>


	<input name="name" type="text" placeholder="insert name here">

	<div style="text-align: center; color: red; margin: 5px">
		<label for="Name">${yearException}</label>
	</div>

	<input name="year" type="number" placeholder="insert year here">

	<select name="developerId">
		<c:forEach var="developer" items="${developerDTOs}">

			
			<option value="${developer.id}">${developer.name}</option>

		</c:forEach>
	</select>

	<select name="genreIds" multiple="multiple">
		<c:forEach var="genre" items="${genreDTOs}">
			
			<option value="${genre.id}">${genre.name}</option>
		</c:forEach>
	</select>

	<button>save Game</button>
</form:form>

<br>
<br>
<a href="newDeveloper">new Developer</a>
<br>
<a href="newGenre">new Genre</a>
<br>
<a href="newOffer">new Offer</a>