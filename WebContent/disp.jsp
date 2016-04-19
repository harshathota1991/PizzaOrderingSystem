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


	<s:form action="addcart" theme="simple" name="form1">
	<s:hidden name="action" value="addCart"></s:hidden>
		
				
					<s:textfield name="cartBean.quantity" />
				<s:textfield name="cartBean.quantity" />
	<s:submit value="click"></s:submit>
	</s:form>
	</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
	

</body>
</html>