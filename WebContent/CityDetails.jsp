<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STOREID VIEW</title>

<sx:head />
<script>
	dojo.event.topic.subscribe("/value", function(value, key, text, widget) {
		dojo.event.topic.publish("show_detail");
	});
</script>
</head>
<body style="text-align: center" bgcolor="lavender">
<s:if
		test="#session.credentials.userID!=null && #session.credentials.password!=null">
	<s:actionmessage />

	<s:form id="form1">
	
		<sx:autocompleter name="storebean.city" list="storeCityList"
			label="Select StoreID     " valueNotifyTopics="/value" />
		<s:hidden name="action" value="viewStoreIdByCity"></s:hidden>
		<%-- <s:submit name="submit"></s:submit> --%>
	</s:form>
	<s:url value="viewStoreIdByCity.action" id="url" />
	<sx:div id="details" href="%{url}" preload="false"
		listenTopics="show_detail" formId="form1"
		showLoadingText="Please wait"></sx:div>
	</s:if>
<s:else>
		YOUR SESSION EXPIRED PLEASE LOGIN AGAIN!
<s:a href="LoginMain.jsp">Login</s:a>
	</s:else>
</body>
</html>