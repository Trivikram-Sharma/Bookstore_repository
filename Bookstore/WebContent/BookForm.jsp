<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Form Page</title>
</head>
<body>
	<h4><a href="BookForm.jsp">Add New Book</a></h4>
	<h4><a href="BookList.jsp">List All Books</a></h4>
	
	<c:if test="${empty book}">
		
		<h1>Add New Book</h1>
		<form action="AddBook" method="get">
			<table>
			<tr><th>Title</th><td><input type="text" name="title"></td></tr>
			<tr><th>Author</th><td><input type="text" name="author"></td></tr>
			<tr><th>Price</th><td><input type="number" name="price"></td></tr>
			<tr><td colspan="2"><input type="submit" name="Submit" value="Save"></td></tr>
			</table>
		</form>
	</c:if>
	<c:if test="${not empty book}">
		<h1>Edit Book Details In the text boxes below</h1>
		<form action="UpdateServlet" method="get">
		<input type="hidden" name="id" value="${book.id }">
			<table>
			<tr><th>Title</th><td><input type="text" name="title" value="${book.title }"></td></tr>
			<tr><th>Author</th><td><input type="text" name="author" value="${book.author }"></td></tr>
			<tr><th>Price</th><td><input type="number" name="price" value="${book.price }"></td></tr>
			
			<tr><td colspan="2"><input type="submit" name="Submit" value="Save"></td></tr>
			</table>
			
		</form>
	</c:if>
</body>
</html>