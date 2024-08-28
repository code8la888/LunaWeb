<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="brad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<brad:tag2 />
	<hr />
	<brad:tag1 /><br />
	Lottery: <brad:lottery /><hr />
	<table width="100%" border="1">
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<brad:item name="iPhone" price="3,000" />
		<brad:item name="Mouse" price="100" />
		<brad:item name="Mic" price="2000" />
		<brad:item name="NB" price="40000" />
		<hr />
	</table>
	</body>
</html>