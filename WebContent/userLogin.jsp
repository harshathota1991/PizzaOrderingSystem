<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.errorMessage{color:red;}

</style>

</head>
<body>

<div style="background-color:#19A319; width:35%;height:420px;float:right;">
<h2 align="center">Login</h2>
<s:actionmessage/>
<fieldset>
<center>

<s:form action="login">


<s:hidden name="action" value="login"></s:hidden>
<br>
<br><br>
<table>
<tr>
<td><s:textfield name="userID" label="User ID" value="%{profileBean.userID}"></s:textfield></td>
</tr>
<tr>
<td><s:password name="password" label="Password" ></s:password></td>
</tr>
<tr>
<td colspan="1"><s:checkbox name="remember" label="Remember me on this Computer"></s:checkbox>
&nbsp;
<s:submit method="execute" label="Login"></s:submit></td>
</tr>
<tr>
<td><a href="register.jsp">New User</a></td>
</tr>
</table>

</s:form>
</center>
</fieldset>
</div>


</body>
</html>