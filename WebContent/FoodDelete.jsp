<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STOREDELETE</title>
</head>
<body style="text-align: center" bgcolor="aqua">
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">
	<s:form action="deleteFood" theme="simple">


		<s:hidden name="action" value="deleteFood" />
		<s:hidden name="foodBean.foodID" value="%{foodBean.foodID}" />
		<table>
			<tr>
				<td>FoodID</td>
				<td>::</td>
				<td><s:property value="%{foodBean.foodID}" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td>::</td>
				<td><s:property value="%{foodBean.name}" /></td>
			</tr>
			<tr>
				<td>Food type</td>
				<td>::</td>
				<td><s:property value="%{foodBean.type}" /></td>
			</tr>
			<tr>
				<td>foodSize</td>
				<td>::</td>
				<td><s:property value="%{foodBean.foodSize}" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td>::</td>
				<td><s:property value="%{foodBean.Quantity}" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td>::</td>
				<td><s:property value="%{foodBean.price}" /></td>
			</tr>

			<tr>
				<td>Do you want to delete the above record Permanently:: <s:submit
						value="Confirm Delete"></s:submit></td>
			</tr>
		</table>

	</s:form>
	</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>