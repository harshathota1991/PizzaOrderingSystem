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

	<s:form action="modifyFood">
		<s:hidden name="action" value="modifyFood"></s:hidden>
		<s:textfield name="foodBean.foodID" label="Food Id"
			value="%{foodBean.foodID}" readonly="true"></s:textfield>
		<s:textfield name="foodBean.name" label="Name"
			value="%{foodBean.name}" readonly="true"></s:textfield>
		<s:select list="{'Veg','Non-Veg'}" name="foodBean.type" label="Type" value="%{foodBean.type}" />
		<br>
		<s:select list="{'Small','Medium','Large'}" name="foodBean.foodSize" label="Food Size"
			value="%{foodBean.foodSize}" />
		<br>
		<s:textarea name="foodBean.quantity" label="Quantity"
			value="%{foodBean.quantity}" />
		<br>
		<s:textarea name="foodBean.price" label="Price"
			value="%{foodBean.price}" />

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