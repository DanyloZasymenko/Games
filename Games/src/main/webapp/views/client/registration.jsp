<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!-- 
	<c:forEach var="clientDTO" items="${clientDTOs}">
	
		${clientDTO.name} ${clientDTO.email} <a href="deleteClient/${clientDTO.id}">delete</a>

	</c:forEach>
-->
<form:form modelAttribute="client" action="saveClient" method="post">

	<div style="text-align: center; color: red; margin: 5px">
		<label for="Name">${nameException}</label>
	</div>
	<form:input path="name" type="text" placeholder="Name" />
	<br>
	<div style="text-align: center; color: red; margin: 5px">
		<label for="Name">${emailException}</label>
	</div>
	<form:input path="email" type="email" placeholder="Email" />
	<br>
	<div style="text-align: center; color: red; margin: 5px">
		<label for="Name">${passwordException}</label>
	</div>
	<form:input path="password" type="password" placeholder="Password" />
	<br>

	<button>save</button>

</form:form>
