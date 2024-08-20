package tw.luna.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.luna.apis.Bike;

@WebServlet("/Luna11")
public class Luna11 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher= request.getRequestDispatcher("Luna12");
		
		request.setAttribute("x", 10);
		request.setAttribute("name", "peter");
		request.setAttribute("aname", "Mike");
		
		Bike b1=new Bike();
		b1.upSpeed();b1.upSpeed();
		request.setAttribute("bike", b1 );
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<h1>Brad Big Company</h1>")
			.append("<hr />")
			.append("<div>Hello,world</div>")
			.append("<hr />");
		dispatcher.include(request, response);
		out.append("<hr />");
		
		response.flushBuffer();
	}
	
}
