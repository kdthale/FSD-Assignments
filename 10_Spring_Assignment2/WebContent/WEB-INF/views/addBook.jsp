
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Add Book</title>
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
			<a  href="<c:url value="/addBook" />">Add Book</a>
			<a  href="<c:url value="/deleteSubject" />">Delete Subject</a>
			<a  href="<c:url value="/deleteBook" />">Delete Book</a>
			<a  href="<c:url value="/searchBook" />">Search a Book</a>
			<a  href="<c:url value="/searchSubject" />">Search a Subject</a>
			<a  href="<c:url value="/exit" />">Exit</a>
		</div>
		
		<%-- <img src="<c:url value="/resources/css/download.jpg" />" alt="Mountain"> --%>
		
	</section>
	<br />
	<br />
	<section>
		<div align="center">
			<form action="addBook" method="post">
				<table>
					<tr><td>Enter the Book ID: </td><td> <input type="text" name="bookId"></input><br /></td></tr>
					<tr><td>Enter the Book Title: </td><td> <input type="text" name="title"></input><br /></td></tr>
					<tr><td>Enter the Book Price: </td><td><input type="text" name="price"></input><br /></td></tr>
					<tr><td>Enter the Book Volume:</td><td> <input type="text" name="volume"></input><br /></td></tr>
					<tr><td>Enter the Publish Date:</td><td> <input type="date" name="publishDate"></input><br /></td></tr>
					<tr><td>Enter the Subject ID: </td><td><input type="text" name="subjectId"></input><br /></td></tr>
					<tr><td>Enter the Subject Title: </td><td><input type="text" name="subjectTitle"></input><br /></td></tr>
					<tr><td>Enter the Subject Duration in hours: </td><td><input type="text" name="durationInHours"></input><br /></td></tr>
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