package tw.luna.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.luna.apis.MemberDB;

@WebServlet("/Register")
public class Register extends HttpServlet {
    
	private MemberDB memberDB=null;
	
    public Register() {
	      try {
			memberDB = new MemberDB();
		} catch (Exception e) {
			System.out.println(e);
		}
   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(memberDB == null) return;
		
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		if (!memberDB.isAccountExist(account)) {
				try {
					if(memberDB.addMember(account, passwd, name)){
						response.sendRedirect("luna17.jsp");
					}else {
						response.sendRedirect("luna16.jsp?errType=3");
					}
				} catch (Exception e) {
					response.sendError(500, e.toString());
				}
		}else {
				response.sendRedirect("luna16.jsp?errType=1");//帳號重複
		}
	}

}
