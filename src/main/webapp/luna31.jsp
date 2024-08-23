<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int a = (Integer)application.getAttribute("a");
	a++;
	application.setAttribute("a", a);
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		a=${a }
	</body>
</html>