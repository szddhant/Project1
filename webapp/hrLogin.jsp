<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>Welcome to HR Login Page!</h1>

	<% 
		String error = (String)request.getAttribute("error");
	%>
	<%= error == null ? "" : error%>
	<form action="HrLoginAuthentication" align="center" method="post">
	<table align="center">
	<tr>
	<td><pre><b>Email    : </b></pre></td>
	<td><input type="email" name="email" placeholder="Enter Email" required/></td>
	</tr><br><br>
	<tr>
	<td><pre><b>Password : </b></pre></td>
	<td><input type="password" name="password" placeholder="Enter Password" required/></td>
	</tr><br><br>
	<tr>
	<td><pre>         <input type="submit" value="Submit"/>  </pre></td>
	</tr>
	</table>
	</form>
</body>
</html>