<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.bean.HrBean" %>
<%@ page import ="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title> Show Hr </title>
</head>
<body align="center">
	<br><br><br><br>
	<pre><h1>HR List</h1>                                                                                                               <a href="adminHome.jsp">back</a></pre>
	
		
		
			<br>
			<br>
			
			<table align = "center" border="1">
				<tr>
					<th>Hr_Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone no.</th>
					<th>Opr1</th>
					<th>Opr2</th>
				</tr>
				
				<c:forEach items="${hrDet}" var="hrBean">
				<tr>
					<td>${hrBean.hr_id}</td>
					<td>${hrBean.name}</td>
					<td>${hrBean.email}</td>
					<td>${hrBean.phone}</td>
					<td><a href="DeleteHrController?hr_id=${hrBean.hr_id}">Delete</a></td>
					<td><a href="EditHrController?hr_id=${hrBean.hr_id}">Edit</a></td>
				</tr>
				</c:forEach>
			</table>
			<br>
			<br>
		
</body>
</html>