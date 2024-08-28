<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/iii"
	user="root"
	password="root"
/>
<c:set var="sql">
	select * from gift
</c:set>

<c:if test="${! empty param.key }">
	<c:set var="sql">select * from gift where name like '%${param.key}%' or addr  like'%${param.key}%'</c:set>
</c:if>

<sql:query var="rs">
	${sql }
</sql:query>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		共${rs.rowCount }筆資料<hr>
		<c:forEach var="fieldName" items="${ rs.columnNames}">
			${fieldName}<br>
		</c:forEach>
		<hr>
			<form>
				keyword:<input name="key" value="${param.key }">
				<input type="submit" value="Search">
			</form>
		</hr>
		<table border="1" width="100%">
			<tr>
			<th>id</th>
			<th>Name</th>
			<th>ADDR</th>
			<th>PIC</th>
			</tr>
			<c:forEach var="gift" items="${rs.rows }"> 
				<tr>
					<td>${gift.id }</th>
					<td>${gift.name }</th>
					<td>${gift.addr }</th>
					<td><img src="${gift.picurl}" width="160px" height="90px">
					</th>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>