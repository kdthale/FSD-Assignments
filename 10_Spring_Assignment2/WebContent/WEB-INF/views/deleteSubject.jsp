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
		</div>
		
		<%-- <img src="<c:url value="/resources/css/download.jpg" />" alt="Mountain"> --%>
		
	</section>
	<br />
	<br />
	<section>
		<div align="center">
			<form action="deleteSubject" method="post">
				<table>
					<tr><td>Enter the Subject ID which you want to delete: </td><td> <input type="text" name="subjectId"></input><br /></td></tr>
				</table>
				<br />
				<input type="submit"></input>
			</form>
		</div>
		<p><span>${message}</span></p>
	</section>
	


<!-- <form action="user" method="post">
		<input type="text" name="userName"><br> <input
			type="submit" value="Login">
</form> -->
</body>
</html>