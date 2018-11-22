<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
</head>
<body>
	<article>
		<header>
			<div class="title">
				<h1>Library</h1>
			</div>
		</header>
	</article>
	<section>
		<div>
			<a class="link" href="<c:url value="/addBook" />">Add Book</a>
			<a class="link" href="<c:url value="/deleteSubject" />">Delete Subject</a>
			<a class="link" href="<c:url value="/deleteBook" />">Delete Book</a>
			<a class="link" href="<c:url value="/searchBook" />">Search a Book</a>
			<a class="link" href="<c:url value="/searchSubject" />">Search a Subject</a>
			<a class="link" href="<c:url value="/exit" />">Exit</a>
			
			
			
			<!-- <form action="addBook" method="get">
				<button class="button" type="submit" >Add Book</button>
			</form>
			<form action="deleteSubject" method="get">
			<button class="button" type="button" >Delete Subject</button>
			</form>
			<form action="deleteBook" method="get">
			<button class="button" type="button" >Delete Book</button>
			</form>
			<form action="searchBook" method="get">
			<button class="button" type="button" >Search a Book</button>
			</form>
			<form action="searchSubject" method="get">
			<button class="button" type="button" >Search a Subject</button>
			</form>
			<form action="exit" method="get">
			<button class="button" type="button"  >Exit</button>
			</form> -->
		</div>
		
		<%-- <img src="<c:url value="/resources/css/download.jpg" />" alt="Mountain"> --%>
		
	</section>



<!-- <form action="user" method="post">
		<input type="text" name="userName"><br> <input
			type="submit" value="Login">
</form> -->
</body>
</html>