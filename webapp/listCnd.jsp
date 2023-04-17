<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.bean.CndBean" %>
<%@ page import ="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<br><br><br><br>
	<pre><h1>Candidates</h1>                                                                                                               <a href="hrHome.jsp">back</a></pre>
	
		
		
			<br>
			<br>
			
			<table align = "center" border="1">
				<tr>
					<th>Cnd_Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone no.</th>
					<th>Branch</th>
					<th>Experience</th>
					<th>Resume</th>
					<th>Opr1</th>
					<th>Opr2</th>
				</tr>
				
				<c:forEach items="${cndDet}" var="cndBean">
				<tr>
					<td>${cndBean.cnd_id}</td>
					<td>${cndBean.name}</td>
					<td>${cndBean.email}</td>
					<td>${cndBean.phone}</td>
					<td>${cndBean.branch}</td>
					<td>${cndBean.exp}</td>
					<td>${cndBean.resume}</td>
					<td><a href="DeleteCndController?cnd_id=${cndBean.cnd_id}">Delete</a></td>
					<td><a href="EditCndController?cnd_id=${cndBean.cnd_id}">Edit</a></td>
				</tr>
				</c:forEach>
			</table>
			<br>
			<br>
		
</body>

</html>