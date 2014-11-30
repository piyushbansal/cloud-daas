package servlet;
import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.App;

public class IndexServlet extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		try
		{
		if(req.getSession().getAttribute("dbInfoMap")==null)
		{
			//TODO read db
			
			if(App.dbInfoMap==null||util.App.adminMap==null)
			{
				App.dbInfo();
			}
			req.getSession().setAttribute("keyspace", App.db);
			req.getSession().setAttribute("dbInfoMap", App.dbInfoMap);
			//req.getSession().setAttribute("adminMap", App.adminMap);
		}
	
	
			
			
		
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			req.setAttribute("cerror", "Connection Error, Please try again later");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			
		}
	}

	

}