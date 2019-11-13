<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>settleup</title>

</head>
<body>
 <div>
<img src="/images/bg.jpg" width="2000" height="70" align="top"/>
</div>
<br>
<div align="center">

<img src="/images/logo.jpg" width="400" height="200" align="middle"/>
</div>

<h2 align="center">Settle UP</h2>

<form action="/update-settleup" method="POST">
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

</body>


</html>