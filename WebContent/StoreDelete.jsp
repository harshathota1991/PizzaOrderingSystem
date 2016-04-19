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
	<s:form action="deleteStore" theme="simple">


		<s:hidden name="action" value="deleteStore" />
		<s:hidden name="storebean.storeID" value="%{storebean.storeID}" />
		<table>
			<tr>
				<td>StoreID</td>
				<td>::</td>
				<td><s:property value="%{storebean.storeID}" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td>::</td>
				<td><s:property value="%{storebean.name}" /></td>
			</tr>
			<tr>
				<td>Street</td>
				<td>::</td>
				<td><s:property value="%{storebean.street}" /></td>
			</tr>
			<tr>
				<td>MobileNo</td>
				<td>::</td>
				<td><s:property value="%{storebean.mobileNo}" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td>::</td>
				<td><s:property value="%{storebean.city}" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td>::</td>
				<td><s:property value="%{storebean.state}" /></td>
			</tr>
			<tr>
				<td>PinCode</td>
				<td>::</td>
				<td><s:property value="%{storebean.pincode}" /></td>
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