<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sx:head/>
</head>
<body>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
<style>
.errorMessage{color:red;}
</style>
</head>
<body style="font-family:arial;font-size:20px;color:maroon; background-image:url('npizza2.jpg');font-weight:bold; ">

	<center><h1>New User Registration</h1></center>
<center>

	<s:form action="register">
	<s:actionerror/>
	<s:actionmessage/>
<s:hidden name="action" value="register"></s:hidden>
		<br>
				<s:textfield name="firstName" label="First name" required="true"></s:textfield>	
						
		 		<s:textfield name="lastName" label="Last name"  required="true"></s:textfield>	
		 		
		 		<s:password name="password" label="Password"  required="true"></s:password>	
		 		
		 		<s:password name="confirmPassword" label="Confirm Password"  required="true"></s:password>	
		 			   
				<s:radio list="{'Male','Female'}" label="Gender" name="gender"  required="true"></s:radio>
				
				<sx:datetimepicker name="dateOfBirth" label="Date Of Birth" adjustWeeks="true" displayFormat="MM/dd/yyyy" toggleType="plain" startDate="1900-01-01" endDate="%{'today'}" value="%{'today'}"  required="true"></sx:datetimepicker>
		
	   			<s:textfield name="street" label="Street"  required="true"></s:textfield>	
	   				    
				<s:textfield name="location" label="Location"  required="true"></s:textfield>
								
				<s:select list="{'Tamil Nadu','Karnataka','Andhra Pradesh','Maharashtra','Rajasthan','Gujarat','Himachal Pradesh'}"  name="state" label="State"  required="true"></s:select>
				
				<s:textfield name="city" label="City"  required="true"></s:textfield>
			
				<s:textfield name="pincode" label="Pincode" maxlength="6"></s:textfield>
					
				<s:textfield name="mobileNo" label="Mobile no" maxlength="10"  required="true"></s:textfield>
					
				<s:textfield name="emailID" label="Email ID"  required="true"></s:textfield>
		   
	   <s:submit label="Submit" value="Register" method="execute"></s:submit>
		

	</s:form>
	
	</center>
	
</body>
</html>