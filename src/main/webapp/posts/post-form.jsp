<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="POST" action="/posts" modelAttribute="post">
		<form:hidden path="id" />
		<form:hidden path="version" />
		<input id="user" name="user" type="hidden" value="${userId}">

		<table>
			<tr>
				<td><form:label path="title">Title</form:label></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td><form:label path="body">Body</form:label></td>
				<td><form:input path="body" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>