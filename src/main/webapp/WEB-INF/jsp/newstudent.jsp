<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/add" method="post">
			<table border = "2">
			<input type="hidden" name="idtest" id="idtest" value="${student.id}"/>
			<tr><td><label>Name</label></td><td><input type = "text" value="${student.name}" name = "name" placeholder = "Enter Name here"/></td></tr>
			<tr><td><label>Stream</label></td><td><input type = "text" value="${student.stream}" name = "stream" placeholder = "Enter stream here"/></td></tr>
			
			<tr>
			<td><input type= "reset" value = "Clear"/><input type = "submit" value = "Submit"/></td>	
			</tr>
			</table>
		</form>
		
	</div>
		
</body>
</html>