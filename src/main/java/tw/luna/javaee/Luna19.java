package tw.luna.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

@WebServlet("/Luna19")
public class Luna19 extends HttpServlet {
	private Connection conn;
	public Luna19() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", "root", "root");
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("ooops");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String key= request.getParameter("key");
		String key2="%"+key+"%";
		String sql="select * from gift ";
		if(key!=null) {
			
			sql=  "select * from gift where name like ? or feature like ? or addr like ?";
		}
		RequestDispatcher diaDispatcher= request.getRequestDispatcher("sform.html");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		diaDispatcher.include(request, response);
		
		out.print("<table border='1' width='100%'>");
		out.print("<tr><th>ID</th><th>Name</th><th>feature</th><th>Address</th><th>Photo</th></tr>");
		
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			if(key!=null) {
				pstmt.setString(1, key2);
				pstmt.setString(2, key2);
				pstmt.setString(3, key2);
			}
			ResultSet rs= pstmt.executeQuery();
			while (rs.next()) {
				String id=rs.getString("id");
				String name=rs.getString("name");
				String feature=rs.getString("feature");
				String addr=rs.getString("addr");
				String picurl=rs.getString("picurl");
				
				out.print("<tr>");
				out.printf("<td>%s</td>\n", id);
				out.printf("<td>%s</td>\n", name);
				out.printf("<td>%s</td>\n", feature);
				out.printf("<td>%s</td>\n", addr);
				out.printf("<td><img src='%s' width='160px' height='90px'></td>\n", picurl);
				out.println("</tr>");
				
			}
		} catch (SQLException e) {
			
		}
		response.flushBuffer();
		out.print("</table>");
		
		
	}
}
