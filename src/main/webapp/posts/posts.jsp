<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/posts.css" />">

<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${posts}" var="post">
		<div class="post">
			<div class="title">
			<a href="post/${post.getId()}">${post.getTitle()}</a>
			</div>
			<div class="content">${post.getBody()}</div>
			
			Written by: <a href="/user/${post.getPoster().getId()}">
			${post.getPoster().getName()}
			</a>
		</div>
	</c:forEach>
</body>
</html>