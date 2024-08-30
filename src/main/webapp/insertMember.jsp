<%@page import="org.mindrot.BCrypt"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String USER = "root";
	String PASSWd = "root";
	String URL = "jdbc:mysql://127.0.0.1:3306/iii";
	String SQL_INSERT = "INSERT INTO member (account,passwd,name,icon)" + 
							" VALUES (?,?,?,?)";
	
	Properties prop = new Properties();
	prop.put("user", USER);
	prop.put("password", PASSWd);

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(URL, prop);
	
	String account = request.getParameter("account");
	String passwd = BCrypt.hashpw(request.getParameter("passwd"),BCrypt.gensalt());
	String name = request.getParameter("name");
	byte[] buf = (byte[])request.getAttribute("icon");
	try {
		PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
		pstmt.setString(1, account);
		pstmt.setString(2, passwd);
		pstmt.setString(3, name);
		
		//pstmt.setBinaryStream(4, in);
		pstmt.setBytes(4, buf);
		
		pstmt.executeUpdate();
		
		response.sendRedirect("main.jsp");
		
	}catch(SQLException e) {
		System.out.println(e);
	}	
	
	
%>