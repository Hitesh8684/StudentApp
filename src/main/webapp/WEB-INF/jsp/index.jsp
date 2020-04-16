<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Application</title>
</head>
<body>
<div align = "center">

	<a href="/newStudent">New Student</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>STREAM</th>
			<th>ACTION</th>
		</tr>
			<c:forEach items="${studentList}" var="val">
			<tr>
			<td>${val.id }</td>
			
			<td>${val.name}</td>
		
			<td>${val.stream}</td>
			
			<td><a href = "delete/${val.id }" >delete</a> <a href = "update/${val.id }" >edit</a></td>
			
			
 
		
			
			</tr>
		</c:forEach>
	
	</table>
</div>

</body>
</html>