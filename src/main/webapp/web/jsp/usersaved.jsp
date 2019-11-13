<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h1{
color:green;
}
a{
color:green;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<h1 ><b>User <%= request.getParameter("username") %> Saved</b></h1>
<h2><a href="web/jsp/login.jsp">click to login</a></h2>
</div>
</body>
</html>