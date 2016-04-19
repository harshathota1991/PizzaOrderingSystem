<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

history.forward();
</script>

</head>

<s:head/>
<body>
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">
<u><b>MAKE YOUR PAYMENT:CREDIT CARD</b></u><br><br><br><br>
<s:form action="CreditCard111" validate="true">
<s:hidden name="action" value="CreditCard111"></s:hidden>
<s:actionmessage/>
	<s:textfield label="CreditCardNumber" name="creditcardNo" maxLength="16"/>
	
	
<center><s:submit value="Payment" /></center>
</s:form>
</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>


</body>
</html>