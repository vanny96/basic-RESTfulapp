<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Name: ${user.getName()}
	<br> 
	Email: ${user.getEmail()}
	<br>
	
	<a href="<c:url value="/posts/new?userId=${user.getId()}"/>">New Post</a>

	<div class="posts">
		Posts:
		<c:forEach items="${user.getPosts()}" var="post">
			<div class="post">
				<c:out value="${post.getTitle()}"></c:out>
				<br>
				<c:out value="${post.getBody()}"></c:out>
				<br>

			</div>
		</c:forEach>
	</div>
</body>
</html>