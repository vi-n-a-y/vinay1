
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

	<%double sal=(Double)request.getAttribute("sal"); %>
	<%out.print(request.getAttribute("sal")); %>

	<% 
        // Retrieve the double value from session
        HttpSession session1 = request.getSession();
        double sali = (Double)session1.getAttribute("sal");
    %>


</body>
</html>
