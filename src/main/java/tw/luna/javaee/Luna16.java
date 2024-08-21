package tw.luna.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.luna.apis.LunaUtils;

/**
 * Servlet implementation class Luna16
 */
@WebServlet("/Luna16")
public class Luna16 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//取出 Attribute
		String result =(String)request.getAttribute("result");
		String x =(String)request.getAttribute("x");
		String y =(String)request.getAttribute("y");
		String view =(String)request.getAttribute("view");
		
		
		
		try {
			//load view
			String webPage = LunaUtils.loadView(view);
			System.out.println(webPage);
			//show view
			response.getWriter().printf(webPage,x,y,result);
			response.flushBuffer();
		} catch (Exception e) {
			response.getWriter().printf("!!!Error!!!");
			response.flushBuffer();
		}
		
	}


}
