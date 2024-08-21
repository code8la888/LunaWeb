package tw.luna.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Luna01
 */
@WebServlet("/Luna01")
//指定servlet映射到特定的URL路徑，當訪問/Luna01時，這個servlet會被調用
public class Luna01 extends HttpServlet {
	//servlet是用來處理客戶端的請求並生成響應
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet()方法用來處理get請求。get請求主要用於請求數據。
		//request參數包含客戶端的請求信息，response參數用來設定回傳給客戶端的響應

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("OK");
		PrintWriter pw= response.getWriter();
		//PrintWriter物件用來向客戶端輸出字串，此物件與響應(response)有關，可以通過它將內容寫回客戶端。
		pw.print("Hello, Luna");
		//輸出"Hello,Luna"到客戶端，這將成為響應內容的一部分，並顯示在客戶端的瀏覽器。
	}
}
