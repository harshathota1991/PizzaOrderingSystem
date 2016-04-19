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

	<s:form theme="simple" action="modifyCartDetails">
 <s:hidden name="action" value="modifyCartDetails"></s:hidden>
		<table border="5" align="center">
			<tr align="center" bgcolor="lavender" bordercolor="green">
				<th>select to modify</th>
				<th>cart id</th>
				<th>userid</th>
				<th>foodid</th>
				<th>type of food</th>
				<th>quantity</th>
				<th>Price</th>
				<th>order date</th>
				
			</tr>
			<s:iterator value="arrayList">
				<tr align="center">
					 <td> <s:checkbox fieldValue="%{foodID}" name="foodBean.foodID" /></td>
					 <td><s:property value="cartID" /></td>
					<td><s:property value="userID" /></td>
					<td><s:property value="foodID" /></td>
					<td><s:property value="type" /></td>
					<td><s:textfield value="%{quantity}" name="foodQty"/></td>
					<td><s:property value="cost" /></td>
					<td><s:property value="orderDate" /></td>
					
					
				</tr>
			</s:iterator>

		
		</table>
	<s:submit  value="CONFIRM"> </s:submit>
	</s:form>
	</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>