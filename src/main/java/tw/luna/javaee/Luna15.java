package tw.luna.javaee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.luna.apis.MyModel;

/**
 * Servlet implementation class Luna15
 */
@WebServlet("/Luna15")
public class Luna15 extends HttpServlet {//控制
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//接受參數
		request.setCharacterEncoding("UTF-8");
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		//運算
		try {
			MyModel myModel= new MyModel(x, y);
			String result = myModel.plus();
			request.setAttribute("result", result);
			request.setAttribute("x", x);
			request.setAttribute("y", y);
			request.setAttribute("view", "view");
		} catch (Exception e) {
			request.setAttribute("result", "無法計算...");
			request.setAttribute("x", x==null?"":x);
			request.setAttribute("y", y==null?"":y);
			request.setAttribute("view", "view");
		}
		//呈現view
		response.setContentType("text/HTML; charset=UTF-8");
		//設定響應的內容類型為 HTML 文本,並指定字元編碼為 UTF-8
		RequestDispatcher dispatcher=request.getRequestDispatcher("Luna16");
		dispatcher.forward(request, response);
	}


}
