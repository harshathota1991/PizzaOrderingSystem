<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">
<s:form action="orderProcess" theme="simple">
<s:hidden name="action" value="orderProcess"></s:hidden>
<table border="1">
<tr><th>Order ID</th>
<th>User ID</th>
<th>Order Date</th>
<th>Total Price</th>
<th>Street</th>
<th>City</th>
<th>State</th>
<th>Pincode</th>
<th>Mobile No</th>
<th>Cart ID</th>
<th>Order Status</th>
</tr>

<s:iterator value="arrayList">

<tr><td>	<s:radio list="orderID" name="orderID"></s:radio></td>
	<td><s:property value="userID"/></td>
	<td><s:property value="orderDate"/></td>
	<td><s:property value="totalPrice"/></td>
	<td><s:property value="street"/></td>
	<td><s:property value="city"/></td>
	<td><s:property value="state"/></td>
	<td><s:property value="pincode"/></td>
	<td><s:property value="mobileNo"/></td>
	<td><s:property value="cartID"/> </td>
	<td><s:property value="orderStatus"/> 
	</td></tr>
</s:iterator>
</table><br>
<table border="1" align="center">
<tr>
<td><s:radio list="{'Pending'}" name="orderStatus"></s:radio></td>
<td><s:radio list="{'Delivered'}" name="orderStatus"></s:radio></td>
<td><s:radio list="{'Confirmed'}" name="orderStatus"></s:radio></td>
<td><s:radio list="{'Cancelled'}" name="orderStatus"></s:radio></td>
</tr></table><br>
<center><s:submit ></s:submit></center>
</s:form>
</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>