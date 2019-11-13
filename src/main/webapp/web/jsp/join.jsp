<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
<style> 
input {
  width: 100%;
  color: green;
  
}
</style>
</head>
<body>

<div>

<img src="/images/bg.jpg" width="2000" height="70" align="top"/>
</div>

<br>
<div align="center">

<img src="/images/logo.jpg" width="400" height="200" align="middle"/>
</div>


<div align="center">
<h2><font face="verdana" color="green">SPLITWISE</font></h2>

</div>

<form:form name="save-user" action="/save-user" method="POST">

<div align="center">
<table>
<tr>
<td>Email ID</td>
<td><input type="text" name="email_id" /></td>
</tr>
<tr>
<td>User Name</td>
<td><input type="text" name="username" /></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit" /></td>
</tr>
</table>



<div style="color: red">${error}</div>

</div>
</form:form>
<br>

<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">
			
				<%
				if (request.getParameter("message") != null) {
			        out.println("<b>"+request. getParameter("message")+"</b>!");
			    }
                 %>
			</td>
		</tr>
	</table>
</body>
</html>