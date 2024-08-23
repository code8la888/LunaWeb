<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name1 = "Brad";
	pageContext.setAttribute("name11", name1);
	
	String name2 ="Eric";
	request.setAttribute("name11", name2);
	
	String name3 ="Vivi";
	session.setAttribute("name11", name3);
	
	String name4 ="Joe";
	application.setAttribute("name11", name4);
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Name: ${name11}<br>
	</body>
</html>