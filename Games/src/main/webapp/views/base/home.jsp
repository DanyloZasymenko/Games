<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<link rel="stylesheet" href="css/home.css">

<security:authentication property="name" />

<security:authorize access="hasRole('ROLE_ADMIN')">

	<form:form action="admin" method="get">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button>profile</button>
	</form:form>


</security:authorize>

<security:authorize access="hasRole('ROLE_USER')">

	<form:form action="profile" method="get">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button>profile</button>
	</form:form>

</security:authorize>

<security:authorize access="isAuthenticated()">

	<form:form action="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button>logout</button>
	</form:form>

</security:authorize>

<security:authorize access="!isAuthenticated()">

	<br>
	<a href="loginpage">login</a>
	<br>
	<a href="registration">registration</a>
	<br>
	<br>
	Login to buy game

</security:authorize>

<br>
<br>
<c:forEach var="offer" items="${offerDTOs}">
	<div class="offersHome">
		${offer.name} ${offer.price}
		<security:authorize access="isAuthenticated()">
			<a href="toBasket/${offer.id}">to basket</a>
		</security:authorize>
		<br>
	</div>
</c:forEach>