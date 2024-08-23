<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println(request.getMethod());
	//if(!request.getMethod().equals("POST")) response.sendError(405);
	
	String account = request.getParameter("account");
	String[] habbits = request.getParameterValues("habbit");
	System.out.println(habbits.length);
	request.getRemoteAddr();
	Locale loc= request.getLocale();
	loc.getDisplayLanguage();
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Method:${pageContext.request.method}<br>
		1.${paramValues.habbit[0]}<br>
		2.${paramValues.habbit[1]}<br>
		3.${paramValues.habbit[2]}<br>
		4.${paramValues.habbit[3]}<br>
		5.${paramValues.habbit[4]}<br>
		6.${paramValues.habbit[5]}<br>
		7.${paramValues.habbit[6]}<br>
		<hr>
		${pageContext.request.remoteAddr}<br>
		${pageContext.request.locale}<br>
		${pageContext.request.locale.displayLanguage}<br>
	</body>
</html>