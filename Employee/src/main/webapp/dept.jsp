<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>successFully getting data</h1>

	<%
	String name = (String) request.getAttribute("name");
	Date hireDate = (Date) request.getAttribute("hireDate");

	out.println("Name is : " + name);

	out.println("Hire Date is  : " + hireDate);
	%>


	<%
	Double sal = (Double) request.getAttribute("sal");

	out.println(sal);
	if (sal != null) {
	%>
	<form action="emp" method="post">

		<label>Update Salary : </label><input type="text" value="<%=sal%>"
			name="updateSalary" />
		<button>update</button>
	</form>
	<%
	} else {
	%>
	<form action="emp" method="post">
		<h1>Enter your Salary</h1>
		<label>Update Salary : </label><input type="text" name="updateSalary" />
		<button>update</button>
	</form>


	<%
	}
	%>




</body>
</html>
