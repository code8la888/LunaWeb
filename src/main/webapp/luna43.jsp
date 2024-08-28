<%@page import="tw.luna.apis.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("obj2");
	if (obj == null){
		response.sendRedirect("luna42.jsp");
		//response.sendError(HttpServletResponse.SC_FORBIDDEN, "aaaaa");
	}
	System.out.print(obj);
	//System.out.print(obj instanceof String);
	MyTest lottery = (MyTest)obj;
	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	I am Luns43<hr />
	Lottery: ${obj2.lottery }<br />
	<a href="luna44.jsp">Logout</a>	
	</body>
</html>