package tw.luna.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Luna03
 */
@WebServlet("/Luna03")
public class Luna03 extends HttpServlet {
	//HttpServlet 是Java EE中的一個基礎類別,提供了處理HTTP請求的基本功能
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//當收到HTTP 的get請求時就會執行doGet()方法
		//HttpServletRequest物件包含了客戶端發送的HTTP請求資訊,例如請求參數、請求頭等。
		//HttpServletResponse物件用來輸出HTTP回應,例如設定回應狀態碼、回應頭、回應內容等。
		request.setCharacterEncoding("UTF-8");
		//設定請求的字元編碼為 UTF-8,確保後續處理請求時能正確處理中文字元。
		response.setContentType("text/html; charset=UTF-8");
		//設定回應的內容類型為 "text/html",並指定字元編碼為 UTF-8
		PrintWriter out = response.getWriter();
		out.print("Hello");
	}
}
