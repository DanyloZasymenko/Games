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

	<div style="text-align: center; color: red; margin: 5px" id="exception">
		${Exception}
	</div>


	<input name="name" type="text"
		placeholder="insert name here" id="nameInput" onchange="check()" >

	<input name="year" required="required" type="number"
		placeholder="insert year here">

	<select name="developerId">
		<option selected value="noDeveloper">---Select Developer---</option>
		<c:forEach var="developer" items="${developerDTOs}">

			<option value="${developer.id}">${developer.name}</option>

		</c:forEach>
	</select>

	<select name="genreIds" multiple="multiple" required="required">
		<option selected value="noGenres">---Select Genres---</option>
		<c:forEach var="genre" items="${genreDTOs}">

			<option value="${genre.id}">${genre.name}</option>
		</c:forEach>
	</select>

	<button id="save" onmouseover="check()">save Game</button>
</form:form>

<script type="text/javascript">


function check() {


    if(document.getElementById('nameInput').value == ''){
	
		document.getElementById('save').disabled='disabled';
	
		$('#exception').text('EMPTY_GAME_FIELD');
    }else{
	
		document.getElementById('save').disabled='';
		
		$('#exception').text('');
		}
	}


</script>

<br>
<br>
<a href="newDeveloper">new Developer</a>
<br>
<a href="newGenre">new Genre</a>
<br>
<a href="newOffer">new Offer</a>