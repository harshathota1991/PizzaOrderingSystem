<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN PAGE</title>
<script type="text/javascript">
window.history.forward();
</script>
</head>
<body>
<s:actionmessage/>
	<!-- 
Welcome <s:property value="#session.credentials.userID"/>;
Customer Page
<!--<s:a href="logout">logout</s:a>
<s:a href="changePassword.jsp" >ChangePassword</s:a>
<s:a href="storeCreate.jsp">Create Store</s:a>
<s:a href="addFoodItems.jsp">Add Food</s:a> -->
</body>
</html>