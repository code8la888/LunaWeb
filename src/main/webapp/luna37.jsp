<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<c:catch var="error">
		<sql:setDataSource
			driver="com.mysql.cj.jdbc.Driver"
			url="jdbc:mysql://localhost/iii"
			user="root"
			password="root"
		/>
		<sql:update var="n1">
			update member set account = 'kkk' where id = 8
		</sql:update>
		<sql:update var="n2">
			delete from member where id >= 6
		</sql:update>
	</c:catch>
	${error }
		</body>
</html>