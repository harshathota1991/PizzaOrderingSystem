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
		<u>VIEW STORE DETAILS</u>
	</h1>

	<s:form action="viewFoodDetails2" theme="simple" name="form1">
<s:hidden name="action" value="viewFoodDetails"></s:hidden>
		<table border="5" align="center">
			<tr align="center" bgcolor="lavender" bordercolor="green">
				
				<th>StoreID</th>
				<th>Name</th>
				<th>Street</th>
				<th>Mobile No</th>
			</tr>
			<s:iterator value="storeList">
				<tr align="center">
					<td> <s:radio list="%{storeID}" name="storebean.storeID"/></td>
					<!--  <td><s:property value="storeID" /></td>-->
					<td><s:property value="name" /></td>
					<td><s:property value="street" /></td>
					<td><s:property value="mobileNo" /></td>
				</tr>
			</s:iterator>
		</table>
	<s:submit value="click"></s:submit>
	</s:form>
	</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
	

</body>
</html>