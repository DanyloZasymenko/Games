<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h2>New Developer</h2>
 
<c:forEach var="developer" items="${developerDTOs}">
	<div>
		${developer.name} <a href="deleteDeveloper/${developer.id}">delete</a>
	</div>
</c:forEach>

<br>
 
<form:form modelAttribute="developerDTO" action="saveDeveloper" method="post">

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}"/>

	<div style="text-align: center; color: red; margin: 5px">
		<label for="Name">${developerException}</label>
	</div>

	<input name="name" placeholder="insert developer here"> <br>
	<button>save Developer</button>
</form:form>
<!-- 
<input type="text" id="nameDeveloper">

<button id="saveDeveloper">save Developer</button>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script type="text/javascript" src="js/newDeveloper.js"></script>
-->
<br>
<br>
<a href="newGame">new Game</a>
<br>
<a href="newGenre">new Genre</a>
<br>
<a href="newOffer">new Offer</a>