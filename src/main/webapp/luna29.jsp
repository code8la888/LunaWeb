<%@page import="tw.luna.apis.Bike"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] names1 = {"Brad","Mark","Kevin","John"};
	pageContext.setAttribute("names1", names1);
	
	LinkedList<String> list = new LinkedList<>();
	pageContext.setAttribute("list", list);
	list.add("Brad1");
	list.add("Mark1");
	list.add("Kevin1");
	list.add("John1");
	
	Bike b1=new Bike();
	pageContext.setAttribute("b1", b1);
	
	HashMap<String,Object> map = new HashMap<>();
	pageContext.setAttribute("map", map);
	map.put("1", "Brad1");
	map.put("2",true);
	map.put("3", 18);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		names1[2] = ${names1[2] }<br/>
		list[1]= ${list[1] }<br>
		${map[1]}<br>
	</body>
</html>