<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringJPA</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/search" method = "post">
	<label>Busqueda por codigo: </label><input type="number" placeholder="Ingrese codigo" name="code">
	<input type="submit" value="Enviar">
	</form>
	
	<form action="${pageContext.request.contextPath}/save" method = "post">
	<input type="submit" value="Agregar un nuevo usuario">
	</form>
	
	<form action="${pageContext.request.contextPath}/searchBy" method="post">
	<input type="text" name="name" placeholder="Ingrese el nombre: ">
	<input type="number" name="age" placeholder="Ingrese la edad: ">
	<button type="submit">Buscar</button>
	</form>

	<table>
		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Status</th>
		</tr>
			<c:forEach items="${students}" var="students">
				<tr>
					<td>${students.sName}</td>
					<td>${students.lName}</td>
					<td>${students.sAge}</td>
					<td>${students.activoDelegate}</td>
					<td>
					<form action="${pageContext.request.contextPath}/update" method="post">
						<input type="hidden" value="${students.cStudent}" name="code">
						<input type="submit">
					</form>
					</td>
				</tr>	
			</c:forEach>
	</table>
</body>
</html>