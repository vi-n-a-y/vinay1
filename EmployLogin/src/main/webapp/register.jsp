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
<h1>Employ details</h1>
<form action="http://localhost:8080/EmployLogin/Home" method="post">
<table> 
<tr><td><label>Employ Name :</label></td><td><input type="text" name="empname" ></td></tr>
<tr><td><label>Date Of Joining :</label></td><td><input type="date" name="empdoj" ></td></tr>
<tr><td><label>Basic Salary :</label></td><td><input type="text" name="empslry" ></td></tr>
</table>
<input type="submit">
<input type="reset">
</form>
<a href="signin.jsp"><button>Signin</button></a>
</div>


</body>
</html>