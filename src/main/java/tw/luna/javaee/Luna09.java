package tw.luna.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Luna09")
@MultipartConfig( location = "C:\\Users\\USER\\eclipse-workspace\\LunaWeb\\src\\main\\webapp\\upload")
public class Luna09 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out =  response.getWriter();
		
		Part part=request.getPart("upload");
		System.out.println(part.getName());
		System.out.println(part.getSize());
		System.out.println(part.getSubmittedFileName());
		String filename= request.getRemoteAddr() +"_"+ part.getSubmittedFileName();
		
		System.out.println(filename);
		if(part.getSize()>0) {
			part.write(part.getSubmittedFileName());
			out.println("Success");
		}else {
			out.println("fail");
		}
	}
}
