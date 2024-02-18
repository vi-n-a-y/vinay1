<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.vin.EmpDto" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<%EmpDto dto=(EmpDto)session.getAttribute("dto"); 

if(dto!=null){%>
<table>
<tr><td>EmpId</td><td><input type="text" value=<%=dto.getId() %>></td></tr>
<tr><td>Employee Name</td><td><input type="text" value=<%=dto.getEmpName() %>></td></tr>
<tr><td>Employee Date of Joining</td><td><input type="text" value=<%=dto.getDoj() %>></td></tr>
<tr><td>Basic Salary</td><td><input type="text" value=<%=dto.getSalary() %>></td></tr>
</table>

<table>
<tr><td>HRA</td><td><input type="text" value=<%=dto.getSalary()*0.2 %>></td></tr>
<tr><td>DA</td><td><input type="text" value=<%=dto.getSalary()*0.3 %>></td></tr>
<tr><td>GS</td><td><input type="text" value=<%=dto.getSalary()+dto.getSalary()*0.2+dto.getSalary()*0.3 %>></td></tr>
<tr><td>PF</td><td><input type="text" value=<%=dto.getSalary()*0.125 %>></td></tr>
<tr><td>NS</td><td><input type="text" value=<%=(dto.getSalary()+dto.getSalary()*0.2+dto.getSalary()*0.3)-(dto.getSalary()*0.125) %>></td></tr>



</table>

<%}else{ %>
<h1>Successfully inserted the data</h1>
<h1>insert employee details</h1>


<%} %>
</div>
</body>
</html>
