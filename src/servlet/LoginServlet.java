package servlet;
import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.App;

public class LoginServlet extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {



		try
		{
			TreeMap<String, String> adminMap = null;
		if(App.adminMap==null)
		{
			
				App.dbInfo();

			
		}
		adminMap=App.adminMap;
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println("username:"+username+" password:"+password);
		if(username!=null&&password!=null&&adminMap.containsKey(username)&&password.equals(adminMap.get(username)))
		{
			req.getSession().setAttribute("admin", "true");
			req.getRequestDispatcher("/manage.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("cerror", "Invalid credential");
			req.getSession().setAttribute("admin", "false");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			req.setAttribute("cerror", "Connection Error, Please try again later");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			
		}
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
	}


	

}