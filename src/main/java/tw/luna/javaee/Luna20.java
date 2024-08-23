package tw.luna.javaee;

import org.mindrot.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Luna20")
public class Luna20 extends HttpServlet {
	private Connection conn;
	
	public Luna20() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", "root", "root");
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("ooops");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.sendError(500,"get out here");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account =request.getParameter("account");
		String password =request.getParameter("password");
		
		if(account == null) {
			response.sendRedirect("login.html"); //若未輸入帳號就轉向登入畫面
			return;
		}
		
		System.out.println("debug1");
		
		try {
			String sql="select * from member where account = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String hashPassword = rs.getString("passwd");
				System.out.println("debug3");
				if (BCrypt.checkpw(password, hashPassword)) {
					System.out.println("登入成功");
					response.sendRedirect("main.html");
				}else {
					System.out.println("輸入密碼錯誤，請重新輸入");
					response.sendRedirect("login.html");
				}
			}else {
				System.out.println("enter...");
				response.sendRedirect("請入帳號密碼");
			}
			
		} catch (SQLException e) {
			response.sendRedirect("login.html");
		}
		
	}
}
