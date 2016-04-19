<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FOOD DETAILS</title>
<style>
.errorMessage{color:red;}

</style>
</head>
<body bgcolor="Silver">
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">
<s:actionerror/>
	<center>
		<h2>ADD FOOD DETAILS</h2>
		<s:form action="addFoodDetails">
			<s:hidden name="action" value="addFoodDetails" />
			<s:textfield name="name" required="true" label="Enter Name" />
			<s:radio list="{'Veg','Non-Veg'}" name="type" label="Type"
				required="true" />
			<s:select list="{'Small','Medium','Large'}" name="foodSize"
				label="FoodSize" required="true"></s:select>
			<s:textfield name="quantity" required="true" label="Enter Quantity" />
			<s:textfield name="price" required="true" label="Enter Price" />
			<s:submit value="SUBMIT"></s:submit>
		</s:form>
	</center>
	</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>