<%@page import="tw.luna.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name= request.getParameter("name");
	Bike bike=new Bike();
	bike.upSpeed();
	bike.upSpeed();
	bike.upSpeed();
	bike.upSpeed();
	bike.upSpeed();
	
	request.getParameter(name);
	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		I am luna21<br>
		<jsp:forward page="luna22.jsp"></jsp:forward>
	</body>
</html>