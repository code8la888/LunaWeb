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
<c:set var="rpp">10</c:set>
<c:set var="page">${empty param.page?1:param.page }</c:set>
<c:set var="start">${(page-1)*rpp }</c:set>
<c:set var="prev">${page == 1 ? page : page -1 }</c:set>
<c:set var="next">${page + 1 }</c:set>


<c:set var="sql">select * from gift limit ${start },${rpp }</c:set>

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
		<a href="?page=${prev}">上一頁</a>   <a href="?page=${next}">下一頁</a>
		<hr>
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