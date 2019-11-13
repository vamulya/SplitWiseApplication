<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>

<title>add new</title>
<style>
h1 {
	color: green
}

h2 {
	color: green
}

div {
	color: green
}
</style>
</HEAD>
<body>
	<div>
		<img src="/images/bg.jpg" width="2000" height="70" align="top" />
	</div>
	<br>
	<div align="center">

		<img src="/images/logo.jpg" width="400" height="200" align="middle" />
	</div>

	<h2 align="center">Add New Split</h2>


   <form action="/save-split" method="POST">
<div>	
<label for="Choose Friends"> Choose friend</label>
	<select id="friend" required name="friend">
	<option disabled="disabled" selected="selected">Select your friend</option>
		<c:forEach var="addFriends" items="${list}">
			<option>${addFriends}</option>
		</c:forEach>
	</select>
<br>
<br>

Enter Amount: <input type="number" name="amount"/>
<br>
<INPUT TYPE="submit" VALUE="SAVE" style="height:50px; width:150px; margin-top:50px;align-content:center;color:green">
</div>	
</form>
	<%-- 
<div align="center">
<form:label path = "addFriends">Select Friend</form:label>
  <form:checkboxes items = "${webFrameworkList}" path = "favoriteFrameworks" />     




<label  for="select friend" >SelectFriend:
</label>

<checkboxes items="${list}"/>
<!-- <select name="friends" >
  <option value="Vasa">Vasa</option>
  <option value="Sajid">Sajid</option>
  <option value="Rakesh">Rakesh</option>
  <option value="Amulya">Amulya</option>
</select> -->
<br> <br> <br>

Enter Amount: <input type="text" name="amount"/>
<br>
</div>
<div align="center">
 <INPUT TYPE="BUTTON" VALUE="SAVE" style="height:50px; width:150px; margin-top:100px;align-content:center" ONCLICK="button1()">
</div> --%>
</body>
</HTML>