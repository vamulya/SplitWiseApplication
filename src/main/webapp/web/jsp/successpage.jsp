<HTML>
<HEAD>
<TITLE>SPLIWISE</TITLE>

<style>
h2 {
	color: green
}
</style>
</HEAD>

<BODY>

	<div>
		<img src="/images/bg.jpg" width="2000" height="70" align="top" />
	</div>
	<br>
	<div align="center">

		<img src="/images/logo.jpg" width="400" height="200" align="middle" />
	</div>

	<div align="center">
		<h2>
			<b>Welcome <%= request.getParameter("username") %></b>
		</h2>
	</div>
	<br>

	<FORM NAME="form1" METHOD="POST">
		<INPUT TYPE="HIDDEN" NAME="buttonName"> <a href="settleup"><INPUT
			TYPE="BUTTON" VALUE="Settle UP"
			style="height: 100px; width: 200px; margin-left: 300px; background-color: DarkCyan; color: black"
			ONCLICK="settleUp()"></a> <a href="addnew"><INPUT
			TYPE="BUTTON" VALUE="Add New"
			style="height: 100px; width: 200px; margin-left: 150px; background-color: DarkCyan; color: black"
			ONCLICK="addNew()"></a> <a href="view"><INPUT TYPE="BUTTON"
			VALUE="View"
			style="height: 100px; width: 200px; margin-left: 150px; background-color: DarkCyan; color: black"
			ONCLICK="view()"></a>

	</FORM>

	<SCRIPT LANGUAGE="JavaScript">
            <!--
            function button1()
            {
                document.form1.buttonName.value = "button 1"
                form1.submit()
            }    
            function button2()
            {
                document.form1.buttonName.value = "button 2"
                form1.submit()
            }    
            // --> 
        </SCRIPT>
</BODY>
</HTML>