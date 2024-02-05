<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>performing arithmetic operation on the two numbers</h1>
<form action="Calculations" method="get">
<input type="text" name="num1" placeholder="enter your number..">
<select name="sel">
    <option value="+">+</option>
    <option value="-">-</option>
    <option value="*">*</option>
    <option value="/">/</option>
</select>
<input type="text" name="num2" placeholder="enter your number.."><br><br>
<button >result</button><br><br>


</form>
<input type="text" name="result" placeholder="your result is appear here..." value=<%=request.getAttribute("result") %> >
<input type="reset">

</body>
</html>