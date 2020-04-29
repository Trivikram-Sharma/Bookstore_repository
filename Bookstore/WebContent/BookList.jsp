<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Store Applications</title>
<style>
	h1{
		color:red;
	}
	table{
	text-align:center;
	border:10 px solid black;
	cell-padding : 5 px;
	color : black;
	}
</style>
</head>
<body>
	<h4><a href="BookForm.jsp">Add New Book</a></h4> 
	<h4><a href="BookList.jsp">List All Books</a></h4>
	<!-- 
	<c:if test=" ${bsize==0 }">
	<h1 >BookList could not be retrieved.</h1></c:if>
	<table><tr>
	<th>ID</th>
	<th>Title</th>
	<th>Author</th>
	<th>Price(Rs.)</th>
	<th>Actions</th>
	</tr>
	
	<c:if test = "${bsize>0}">
	
	
	
	<c:forEach var = "book" items="${booklist }">
		<tr>
			<td>${ book.id}</td>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${"Rs"+ book.price}</td>
			<td><a href="EditServlet?bookId=${book.id }">Edit</a><a href="DeleteServlet?bookId=${book.id }">Delete</a></td>
		</tr>
	</c:forEach>
	
	</c:if>
	</table> -->
	<%@ page import="com.model.Book" %>
	<%@ page import="com.dao.BookDao" %>
	<%@ page import="com.dao.BookDaoImpl" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="java.util.*" %>
	<%
		BookDao bd = new BookDaoImpl();
		ArrayList<Book> bookList = bd.getAllBookDetails();
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Title</th>");
		out.println("<th>Author</th>");
		out.println("<th>Price(Rs.)</th>");
		out.println("<th>Actions</th>");
		for(Book b: bookList){
			out.println("<tr>");
			out.println("<td>"+b.getId()+"</td>");
			out.println("<td>"+b.getTitle()+"</td>");
			out.println("<td>"+b.getAuthor()+"</td>");
			out.println("<td>"+b.getPrice()+"</td>");
			out.println("<td><a href='EditServlet?bookId="+b.getId()+"'>Edit</a><a href='DeleteServlet?bookId="+b.getId()+"'>Delete</a></td>");
			out.println("</tr>");
		}
	out.println("</table>");
	%>
</body>
</html>