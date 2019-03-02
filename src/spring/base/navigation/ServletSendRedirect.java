package spring.base.navigation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.service.domain.User;

/**
 * Servlet implementation class ServletSendRedirect
 */
public class ServletSendRedirect extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		
		System.out.println("[ServletSendRedirect.service() start........]");
		
		req.setAttribute("user01", new User("ȫ�浿","1111"));
		
		HttpSession session=req.getSession(true);
		session.setAttribute("user02", new User("�̼���","2222"));
		
		ServletContext application=this.getServletContext();
		application.setAttribute("user03", new User("�庸��","3333"));
		
		//ServletContext sc=this.getServletContext();
		
		//RequestDispatcher rd=sc.getRequestDispatcher("/02Navigation/view.jsp");
		
		//rd.forward(req, res);
		
		res.sendRedirect("/003edu/02Navigation/view.jsp");
		
		System.out.println("[ServletSendRedirect.service() end.......]");
	}
}
