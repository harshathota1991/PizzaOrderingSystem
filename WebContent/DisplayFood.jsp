<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Stores List</title>
<script>
function disabled(){
	document.getElementById("foodQty").readOnly = false;
}
</script>

</head>
<body style="text-align: center" bgcolor="lavender" >
	<h1>
		<u>VIEW FOOD DETAILS</u>
	</h1>


	<s:form action="addCart" theme="simple" name="form1">
		 <s:actionmessage/>
	<s:hidden name="action" value="addCart"></s:hidden>

		<table border="5" align="center">
			<tr align="center" bgcolor="lavender" bordercolor="green">
				<th>click</th>
				
				<th>Name</th>
				<th>type</th>
				<th>Food size</th>
				<th>price</th>
				<th>Enter Quantity</th>
			</tr>
			<s:iterator value="foodList" status="status">
				<tr align="center">
					<td> <s:checkbox name="foodCheck[%{#status.index}]" onchange="disabled()" /></td>
					<!--  <td><s:property value="storeID" /></td>-->
					
					<!-- <td><s:property value="foodID" /></td>-->
					 <td><s:property value="name"/></td>
					<td><s:property value="type" /></td>
					<td><s:property value="foodSize" /></td>
					<td><s:property value="price" /></td>
					<td><s:textfield name="selectedValue[%{#status.index}]" value="0" /></td>
				</tr>
			</s:iterator>
		</table>
	<s:submit value="ADD TO CART"></s:submit>
	</s:form>
	
	

</body>
</html>