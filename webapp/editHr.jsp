<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="com.bean.HrBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<h1>Update Details</h1>
<form action="EditHrController" method = "post">
		<table align="center">
	
	<tr>
	<td><pre><b></b></pre></td>
	<td><input type="hidden" name="hr_id"  value="${hrBean.hr_id}" /></td>
	</tr><br><br>
		
	<tr>
	<td><pre><b>Name      : </b></pre></td>
	<td><input type="text" name="name" value="${hrBean.name}" /></td>
	</tr><br><br>

	<tr>
	<td><pre><b>Email     : </b></pre> </td>
	<td><input type="email" name="email" value="${hrBean.email}" /></td>
	</tr><br><br>
	<tr>
	<td><pre><b>Password  : </b></pre></td>
	<td><input type="password" name="password" value="${hrBean.password}" /></td>
	</tr><br><br>
	
	
	<tr>
	<td><pre><b>Phone no. : </b></pre> </td>
	<td><input type="number" name="phone" value="${hrBean.phone}" /></td>
	</tr><br><br>
	<tr>
	<td><pre>    <input type="submit" value="Update"/></pre></td>
	</tr> 
	
		</table>
	</form>
</body>
</html>