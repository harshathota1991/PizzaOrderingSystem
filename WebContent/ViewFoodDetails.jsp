<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Stores List</title>
</head>
<body style="text-align: center" bgcolor="lavender">
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">
	<h1>
		<u>VIEW FOOD DETAILS</u>
	</h1>

	<s:form>

		<table border="5" align="center">
			<tr align="center" bgcolor="lavender" bordercolor="green">
				<th>FOODID</th>
				<th>Name</th>
				<th>FoodType</th>
				<th>FoodSize</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
			<s:iterator value="foodList">
				<tr align="center">
					<td><s:property value="foodID" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="type" /></td>
					<td><s:property value="foodSize" /></td>
					<td><s:property value="quantity" /></td>
					<td><s:property value="price" /></td>
				</tr>
			</s:iterator>
		</table>


	</s:form>
		</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>