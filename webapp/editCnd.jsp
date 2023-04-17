<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body align="center">
<h1>Update Candidate</h1>
		<form action="EditCndController" method="post">
		<table border="1" align="center">
		
	<tr>
	<td><pre><b></b></pre></td>
	<td><input type="hidden" name="cnd_id"  value="${cndBean.cnd_id}" /></td>
	</tr>
	
	<tr>
	<td><pre><b>Name      : </b></pre></td>
	<td><input type="text" name="name"  value="${cndBean.name}" required/></td>
	</tr>

	<tr>
	<td><pre><b>Email     : </b></pre> </td>
	<td><input type="email" name="email" value="${cndBean.email}" required/></td>
	</tr>
	
	<tr>
	<td><pre><b>Phone no. : </b></pre> </td>
	<td><input type="number" name="phone" value="${cndBean.phone}" required/></td>
	</tr>
	<tr>
	
	<tr>
	<td><pre><b>Experience : </b></pre></td>
	<td>
	<select name="exp" id="exp" value="${cndBean.exp}">
    <option value="">--Experience (in years)--</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10+">10+</option>
	</select>
	
	</td>
	</tr>
	
	<tr>
	<td><pre><b>Linkedin    : </b></pre></td>
	<td><input type="text" name="resume" value="${cndBean.resume}" required/></td>
	</tr><br><br>
	
	<tr>
	<td><pre><b>Branch     : </b></pre></td>
	<td>
	
	<select name="branch" id="branch"  value="${cndBean.branch}">
    <option value="">--SELECT AN OPTION--</option>
    <option value="B.Tech/BE">B.Tech/BE</option>
    <option value="M.Tech/ME">M.Tech/ME</option>
    <option value="BCA">BCA</option>
    <option value="MCA">MCA</option>
    <option value="Bsc">Bsc</option>
    <option value="Msc">Msc</option>
	
	</td>
	</tr>
	
	
	<tr>
	<td><pre><b>Languages  : </b></pre></td>
	<td>
                             <select name="lang" id="lang" multiple="multiple" required >
                                <option value="C">C</option>
                                <option value="C++">C++</option>
                                <option value="Java">Java</option>
                                <option value="PHP">PHP</option>
                                <option value="Python">Python</option>
                                <option value="Ruby">Ruby</option> 
                             </select>
	</td>
	</tr>
	
	<td><pre><b>Technology  : </b></pre></td>
	<td>
	
	<select name="tech" id="tech" multiple="multiple" required >
                                <option value="Blockchain">Blockchain</option>
                                <option value="AI">AI</option>
                                <option value="ML">ML</option>
                                <option value="JSP">JSP</option>
                                <option value="BigData">BigData</option>
                                <option value="Multimedia">Multimedia</option> 
                             </select>
	</td>
	</tr>
	
	<tr>
	<td><pre><b>Databases  : </b></pre></td>
	<td>
	
	<select name="db" id="db" multiple="multiple" required >
                                <option value="mysql">MYSQL</option>
                                <option value="mssql">MSSQL</option>
                                <option value="mongodb">MongoDb</option>
                                <option value="oracle">Oracle</option>
                                <option value="mariadb">MariaDb</option>
                                <option value="xampp">Xamp</option> 
                             </select>
	
	</td>
	</tr>
	
	<td><pre>    <input type="submit" value="Update"/></pre></td>
	</tr> 
	
		</table>
		</form>

</html>