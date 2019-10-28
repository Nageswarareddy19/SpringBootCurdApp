<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th {
	border: 1px solid black;
	border-collapse: collapse;
	background-color: 0000cd;
}

th, td {
	padding: 10px;
	text-align: left;
}
</style>

<script type="text/javascript">
function confirmDelete(bookId) {
	var status = confirm("Are you sure, you want to delete the Book id is" +bookId+ "?");
	if (status) {
		return true;
	} else {
		return false;
	}
}
 
 </script>
</head>
<%@include file="header.jsp"%>
<h3> Books Information</h3>
<body>
	<font color="green">${sMsg}</font>
	<font color="red">${eMsg}</font>
	<c:if test="${!empty bookinfo}">
		<table>
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book Price</th>
				<th>Book Author</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="book" items="${bookinfo}">
				<tr>
					<td>${book.bookId}</td>
					<td>${book.bookName}</td>
					<td>${book.bookPrice}</td>
					<td>${book.author}</td>
					<td><a title="Edit" href="editbook/${book.bookId}"><img
							src="images/Edit.png" width="20" height="20" />Edit</a></td>

					
					<td><a title="Delete" href="deletebook/${book.bookId}" onclick="return confirmDelete(${book.bookId})"><img
							src="images/Delete.png" width="20" height="20" />Delete</a>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>