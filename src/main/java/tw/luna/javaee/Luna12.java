package tw.luna.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.luna.apis.Bike;

@WebServlet("/Luna12")
public class Luna12 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
//		String x=request.getParameter("x");
		
		int intX=(Integer) request.getAttribute("x");
		String aname=(String) request.getAttribute("name");
		Bike b1=(Bike)request.getAttribute("bike");
		
		response.getWriter().printf("Welcome,%s,%d,%s,%s,",name,intX,aname,b1);
		
	}
}
