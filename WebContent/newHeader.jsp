<br><br>
<div align="center" style="font-weight: bold;color:purple;font-size:30px;font-family:Lucida Handwriting">Welcome to PIZZA HUT</div>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body BGCOLOR = "lavender" >

<p align="left" style="font-weight: bold;color:purple;font-size:30px;font-family:Viner Hand ITC">
  Welcome <s:property value="%{#session.credentials.userID}"></s:property><br>
</p>

<p align="right" style="font-weight: bold;color:purple;font-size:20px;font-family:Lucida Handwriting">
<a href="changepasswordAdminLink">Change Password</a>
&nbsp;&nbsp;
<a href="logout?action=logout">Logout</a>

</p>
</body>
</html>