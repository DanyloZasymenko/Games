<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:forEach var="offer" items="${offerDTOs}">
		${offer.name} ${offer.price}
		<a href="deleteOffer/${offer.id}">delete</a>

	<c:forEach var="game" items="${OfferDTOs.games}">
			${game.name}
			<a href="deleteGameFromOffer/${book.id}">delete game</a>

	</c:forEach>
	<br>
</c:forEach>

<br>

<h2>New Offer</h2>

<form:form action="saveOffer" modelAttribute="offerDTO" method="post">

	<select name="gameIds" multiple="multiple">
		<c:forEach var="game" items="${gameDTOs}">
			<option value="${game.id}">${game.name}</option>
		</c:forEach>
	</select>

	<div style="text-align: center; color: red; margin: 5px">
		<label for="Name">${offerException}</label>
	</div>

	<input name="name" type="text" placeholder="input name here" />

	<div style="text-align: center; color: red; margin: 5px">
		<label for="Name">${priceException}</label>
	</div>

	<input name="price" placeholder="input price here" />

	<button>Save Offer</button>

</form:form>
<br>
<br>
<a href="newGame">new Game</a>
<br>
<a href="newDeveloper">new Developer</a>
<br>
<a href="newGenre">new Genre</a>