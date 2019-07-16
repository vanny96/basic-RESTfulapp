<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/generic.css" />">

<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>View</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.getName()}</td>
				<td>${user.getEmail()}</td>
				<td class="link"><a href="/user/${user.getId()}">View</a></td>
				<td class="link"><a href="/user/${user.getId()}/edit">Edit</a></td>
				<td class="link"><a href="/user/${user.getId()}/delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>