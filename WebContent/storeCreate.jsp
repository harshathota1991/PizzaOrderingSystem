<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Store</title>
<style>
.errorMessage{color:red;}

</style>
</head>
<body>
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">
	<center>
		<h2>ADD STORE DETAILS</h2>
		<s:form action="addStore">
		
		<s:hidden name="action" value="addStore" />
		
			<s:textfield name="name" required="true" label="Enter Name" />
			<s:textfield name="street" required="true" label="Enter Street" />
			<s:textfield name="mobileNo" required="true" label="Enter MobileNo" maxlength="10"/>
			<s:textfield name="city" required="true" label="Enter City" />
			<s:textfield name="state" required="true" label="Enter State" />
			<s:textfield name="pincode" required="true" label="Enter PinCode" maxlength="6"/>
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