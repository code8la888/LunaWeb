<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	request.setAttribute("name", "luna");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Hello, World<br>
		<hr>
		<jsp:include page="luna19.jsp">
			<jsp:param value="10" name="x"/>
			<jsp:param value="3" name="y"/>
		</jsp:include>
		<hr>
		<jsp:include page="luna19.jsp"></jsp:include>
	</body>
</html>