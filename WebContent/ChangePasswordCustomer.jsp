<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
window.history.forward();
</script>
<style>
.errorMessage{color:red;}

</style>
</head>
<body BGCOLOR="lightblue">
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">

<center>
	<s:form action="changePasswordCustomerX">
		<s:hidden name="action" value="changePasswordCustomer" />
		<s:actionerror />
		<s:password name="oldPassword" required="true"
			label="Enter old password" />
		<s:password name="newPassword" required="true"
			label="Enter new password" />
		<s:password name="confirmPassword" required="true"
			label="Enter confirm password" />
		<s:submit value="Submit"></s:submit>
	</s:form>
	</center>
	</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>