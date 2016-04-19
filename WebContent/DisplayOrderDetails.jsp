<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Stores List</title>
</head>
<body style="text-align: center" bgcolor="lavender" >
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">
	<h1>
		<u>ORDER DETAILS</u>
	</h1>
<s:actionmessage/>
	<s:form action="CreditCard">
		<table border="5" align="center">
			<tr align="center" bgcolor="lavender" bordercolor="green">
				
				<th>OrderId</th>

<th>Userid</th>

<th>OrderDate</th>

<th>StoreId</th>

<th>TotalPrice</th>

<th>OrderStatus</th>

<th>Street</th>

<th>City</th>

<th>State</th>

<th>PinCode</th>

<th>MobileNo</th>
				
			</tr>
			<s:iterator value="orderArrayList">
				<tr align="center">
					
					<th><s:property value="orderID"/></th>

<th><s:property value="userID"/></th>

<th><s:property value="orderDate"/></th>

<th><s:property value="storeID"/></th>

<th><s:property value="totalPrice"/></th>

<th><s:property value="orderStatus"/></th>

<th><s:property value="street"/></th>

<th><s:property value="city"/></th>

<th><s:property value="state"/></th>

<th><s:property value="pincode"/></th>

<th><s:property value="mobileNo"/></th>
				</tr>
			</s:iterator>
		</table>
	<a href="payement?action=payement">Click here for Payment</a>
	</s:form>
		</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
	

</body>
</html>