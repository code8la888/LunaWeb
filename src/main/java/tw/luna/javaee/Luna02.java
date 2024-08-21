package tw.luna.javaee;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Luna02
 */
@WebServlet("/Luna02")
public class Luna02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//用來處理get請求，request是用戶端的請求訊息，response用來設定傳回客戶端的響應		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String name= headers.nextElement();
			String value= request.getHeader(name);
			System.out.printf("%s: %s\n",name,value);
		}
	}


}
