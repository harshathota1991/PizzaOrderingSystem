<div align="center" style="font-weight:bold;color:blue;font-family:arial;font-size:30px">Welcome to PIZZA HUT!!!</div>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body BGCOLOR = "lightblue" >
<s:if test="#session.credentials.userID!=null && #session.credentials.password!=null">
<p align="left">
  welcome <s:property value="%{#session.credentials.userID}"></s:property><br><br>
</p>

<p align="right">
<a href="logout?action=logout">Logout</a>
<a href="changePassword">Change Password</a>
</p>

</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>