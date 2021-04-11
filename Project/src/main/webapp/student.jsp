<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Student Page</title>
	</head>
	<body>
		<p> Student Name: ${student.name} <p>
		<%--
		<tr th:each="loan: ${loans}">
    		<td th:text="${loan.servicer}" />
    		<td th:text="${loan.name}" />
    		<td th:text="${loan.loanamount}" />
    		<td th:text="${loan.interest}" />
		</tr>
		--%>
	</body>
</html>