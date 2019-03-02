package spring.base.objectscope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScopeTest
 */
public class ApplicationScopeTest extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		res.setContentType("text/html);charset=euc-kr");
		PrintWriter out=res.getWriter();
		
		ServletContext application=req.getServletContext();
		
		Integer count=(Integer)application.getAttribute("count");
		
		if(count==null) {
			out.println("::Browser �Ѱ� 1��° �湮");
			application.setAttribute("count", new Integer(1));
		}else {
			int changeCount=count.intValue()+1;
			out.println("::Browser �Ѱ� "+changeCount+"��° �湮");
			
			application.setAttribute("count", new Integer(changeCount));
		}
	}
}