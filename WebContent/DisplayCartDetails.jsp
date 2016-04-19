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
	<h1>
		<u>CART DETAILS</u>
	</h1>

	<s:form theme="simple">
<!--  <s:hidden name="action" value="modifyCart"></s:hidden> -->
		<table border="5" align="center">
			<tr align="center" bgcolor="lavender" bordercolor="green">
			<!--	<th>select</th> -->
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
					<!--	 <td> <s:checkbox fieldValue="%{cartID}" name="cartBean.cartID" /></td>-->
					 <td><s:property value="cartID" /></td>
					<td><s:property value="userID" /></td>
					<td><s:property value="foodID" /></td>
					<td><s:property value="type" /></td>
					<td><s:property value="quantity" /></td>
					<td><s:property value="cost" /></td>
					<td><s:property value="orderDate" /></td>
				
				</tr>
			</s:iterator>

		
		</table>
			<center>
	<a href="modifyCart?action=mCart">MODIFY CART</a><br>
	<a href="viewFoodDetails11?action=addToCart">ADD TO CART</a><br>	
	<a href="confirmCart?action=confirmCart">CONFIRM ORDER</a><br>
	</center>
	</s:form>
</body>
</html>