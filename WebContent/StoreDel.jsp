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
	<s:form action="deleteStore">


		<s:hidden name="action" value="deleteStore" />
		<s:hidden name="storebean.storeID" value="%{storebean.storeID}" />

StoreID        :: <s:property value="%{storebean.storeID}" />
		
Name               :: <s:property value="%{storebean.name}" />
		
Street         :: <s:property value="%{storebean.street}" />
		
MobileNo.     :: <s:property value="%{storebean.mobileNo}" />
		
City              :: <s:property value="%{storebean.city}" />
		
State              :: <s:property value="%{storebean.state}" />
		
PinCode              :: <s:property value="%{storebean.pincode}" />
		
Do you want to delete the above record Permanently::
<s:submit value="Confirm Delete"></s:submit>


	</s:form>
</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>