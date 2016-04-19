<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STORE MODIFY</title>
<sx:head />
</head>
<body style="text-align: center" bgcolor="lavender">
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">
	<h1>Modify Details</h1>

	<s:actionerror />
<s:actionmessage />
	<s:form action="modifyStore">
		<s:hidden name="action" value="modifyStore"></s:hidden>
		<s:textfield name="storebean.storeID" label="Store Id"
			value="%{storebean.storeID}" readonly="true"></s:textfield>
		<s:textfield name="storebean.name" label="Name"
			value="%{storebean.name}" readonly="true"></s:textfield>
		<s:textarea name="storebean.street" label="Street"
			value="%{storebean.street}" required="true"/>
		<br>
		<s:textfield name="storebean.mobileNo" label="Mobile No."
			value="%{storebean.mobileNo}" required="true" maxlength="10"/>
		<br>
		<s:textarea name="storebean.city" label="City"
			value="%{storebean.city}" required="true"/>
		<br>
		<s:textarea name="storebean.state" label="State"
			value="%{storebean.state}" required="true"/>
		<br>
		<s:textarea name="storebean.pincode" label="Pincode"
			value="%{storebean.pincode}" required="true" maxlength="6"/>
		<br>
		<s:submit value="Update"></s:submit>
	</s:form>
</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>