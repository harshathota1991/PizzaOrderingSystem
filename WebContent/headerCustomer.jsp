<br><br>
<div align="center" style="font-weight: bold;color:purple;font-size:30px;font-family:Lucida Handwriting">Welcome to PIZZA HUT</div>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body BGCOLOR="lightblue">
	<p align="left"  style="font-weight: bold;color:purple;font-size:30px;font-family:Viner Hand ITC" >
		Welcome &nbsp;<s:property value="#session.credentials.userID" />
	</p>

	<p align="right" style="font-weight: bold;color:purple;font-size:20px;font-family:Lucida Handwriting">
		
		<a href="changePasswordCustomerLink">Change Password</a>
		&nbsp;&nbsp;
		<s:a href="logout">Logout</s:a>
	</p>
</body>
</html>