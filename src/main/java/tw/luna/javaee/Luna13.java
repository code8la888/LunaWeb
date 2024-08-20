package tw.luna.javaee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Luna13")
public class Luna13 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		

		RequestDispatcher dispatcher= request.getRequestDispatcher("Luna14");
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print("Hello, I am Brad13");
		dispatcher.forward(request, response);
		response.getWriter().print("after");
	}


}
