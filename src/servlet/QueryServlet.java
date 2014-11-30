package servlet;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import util.utility;

public class QueryServlet extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
		String query="";
			
		try{
			System.out.println(req.getParameter("submitquery"));
			System.out.println("heeeeeeee");
			ResultSet rsfinal;
			query=req.getParameter("submitquery");
			if((rsfinal=utility.queryDb(query))!=null)
			{
				//TODO response make
				ArrayList<ArrayList<Object>> gui=makeGUIResponse(rsfinal);
				req.setAttribute("response", gui);
				req.setAttribute("query", query);
				req.getRequestDispatcher("/response.jsp").forward(req, resp);
			}
			else
			{
				throw new SQLException();
			}
		}
		catch(SQLSyntaxErrorException e)
		{
			 req.setAttribute("cerror", "Invalid query: "+query);
			  req.getRequestDispatcher("/query.jsp").forward(req, resp);
			  e.printStackTrace();
		}
		catch (SQLException e)
		{
			 req.setAttribute("cerror", "Invalid query: "+query);
			  req.getRequestDispatcher("/query.jsp").forward(req, resp);
			  e.printStackTrace();
		}
		catch(Exception e)
		{
			 req.setAttribute("cerror", "Error in connection or query: "+query);
			  req.getRequestDispatcher("/query.jsp").forward(req, resp);
			  e.printStackTrace();
		}	
		
		
		
	
	}
	
private ArrayList<ArrayList<Object>>  makeGUIResponse(ResultSet rs) throws Exception
{
	ArrayList<ArrayList<Object>> arr=new ArrayList<ArrayList<Object>>();
	ResultSetMetaData meta=rs.getMetaData();
	ArrayList<Object> obj=new ArrayList<Object>();
	int colCount=meta.getColumnCount();
	for(int i=1;i<=colCount;i++)
	{
		obj.add(meta.getColumnName(i));
	}
	arr.add(obj);
	
	
	while(rs.next())
	{
		obj=new ArrayList<Object>();
	
		for(int i=1;i<=colCount;i++)
		{
			String colName=meta.getColumnName(i);
			if(meta.getColumnType(i)==java.sql.Types.ARRAY)
			{
				obj.add(rs.getArray(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.BIGINT)
			{
				obj.add(rs.getInt(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.BOOLEAN)
			{
				obj.add(rs.getBoolean(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.BLOB)
			{
				obj.add( rs.getBlob(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.DOUBLE)
			{
				obj.add( rs.getDouble(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.FLOAT)
			{
				obj.add( rs.getFloat(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.INTEGER)
			{
				obj.add( rs.getInt(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.VARCHAR)
			{
				obj.add( rs.getString(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.TINYINT)
			{
				obj.add( rs.getInt(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.SMALLINT)
			{
				obj.add( rs.getInt(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.NUMERIC)
			{
				obj.add( rs.getBigDecimal(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.TIMESTAMP)
			{
				obj.add( rs.getTimestamp(colName));
			}
			else if(meta.getColumnType(i)==java.sql.Types.DATE)
			{
				obj.add( rs.getDate(colName));
			}
			else 
			{
				obj.add( rs.getObject(colName));
			}
		}
		arr.add(obj);
			

	}
	return arr;
}

	}

	

