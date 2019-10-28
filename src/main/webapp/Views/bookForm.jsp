<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 0px solid black;
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
<style type="text/css">
.error {
	color: red;
}
</style>
<meta charset="ISO-8859-1">
<title>Book App</title>

</head>

<body>

<%@include file="header.jsp"%>
	<div align="center">
		<h3>Book Information</h3>

		<font color='green'>${smsg}</font> 
		<font color='red'>${fmsg}</font>


		<form:form action="/register" method="post" modelAttribute="book"
			id="bookForm">

			<table>

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
					<td><input type="submit" value="Add" onclick="submitForm();"></td>
					<td><input type="reset" value="clear">
				</tr>

			</table>
		</form:form>

		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
		<script type="text/javascript">
			function submitForm() {
				var validator = $("#bookForm").validate({
					rules : {
						bookName : "required",
						bookPrice : "required",
						author : "required",

					},

					messages : {
						bookName : " Enter  Book Name",
						bookPrice : " Enter Book Price",
						author : " Enter Book Author",

					}
				});
				if (validator.form()) { // validation perform
					$('form#bookForm').attr({
						action : 'register'
					});
					$('form#bookForm').submit();
				}
			}
		</script>



	</div>

</body>
</html>