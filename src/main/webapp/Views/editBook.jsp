<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}

</style>
</head>
<%@include file="header.jsp"%>

	<h3>Update Book Info</h3>

	<font color="red">${upUnSuc}</font>
	<font color="green">${upSuc}</font>
<body>
	<form:form action="/update" method="post" modelAttribute="book">

		<table>
			<tr>
				<td>Book ID :</td>
				<td><form:input path="bookId" readonly="true"/></td>
				<td><form:errors path="bookId" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Book Name</td>
				<td><form:input path="bookName" /></td>
				<td><form:errors path="bookName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Book Price</td>
				<td><form:input path="bookPrice" /></td>
				<td><form:errors path="bookPrice" cssClass="error" /></td>

			</tr>
			<tr>
				<td>Book Author</td>
				<td><form:input path="author" /></td>
				<td><form:errors path="author" cssClass="error" /></td>

			</tr>
			<tr>
				<td><input type="submit" value="Add"></td>
				<td><input type="reset" value="clear">
			</tr>

		</table>
	</form:form>




</body>
</html>