package servlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import util.App;

public class ManageServlet extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{

		BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
		StringBuilder sb=new StringBuilder();
		for (String line; (line = reader.readLine()) != null;) {
			sb.append(line+"\n");
			//System.out.println(line);
		
		}
		//System.out.println(sb);
		String s=sb.toString();
		int t=s.indexOf("filename=\"");
		s=s.substring(t+10);
	    String fileName=s.substring(0,s.indexOf("."));
	    int c;
		  if((c=s.indexOf("application/json"))==-1)
		  {
			  req.setAttribute("cerror", "Invalid file, please upload only json files");
			  req.getRequestDispatcher("/manage.jsp").forward(req, resp);
		  }
		  else
		  {
			  if(App.dbInfoMap==null)
			  {
				  App.dbInfo();
			  }
			  if(App.dbInfoMap!=null&&App.dbInfoMap.containsKey(fileName))
			  {
				  req.setAttribute("cerror", "Table Already exists");
				  req.getRequestDispatcher("/manage.jsp").forward(req, resp);
			  }
			  else
			  {
				  int tt=s.indexOf("\n",c);
				  tt=s.indexOf("\n",tt+1);
				  int end=s.indexOf("\n",tt+1);
				  s=s.substring(tt+1, end);
				  //s=s.substring(0,s.indexOf("\n"));
				// 
				//  System.out.println(s);
				  TreeMap<String,String> tempMap=new TreeMap<String, String>();
				  if(!insertInDb(fileName,s,tempMap))
					  throw new Exception();
				  else
				  {
					   App.dbInfoMap.put(fileName, tempMap);
					  req.getSession().setAttribute("dbInfoMap",App.dbInfoMap);
					  req.getSession().setAttribute("keyspace",App.db);
					  req.setAttribute("cerror", "Successfully Uploaded");
					  req.getRequestDispatcher("/manage.jsp").forward(req, resp);
				  }
				  //treemap update
			  }
			  
		  }
		}
		catch(Exception e)
		{
			  req.setAttribute("cerror", "Error in upload");
			  req.getRequestDispatcher("/manage.jsp").forward(req, resp);
			  e.printStackTrace();
		}
	}
	protected boolean insertInDb(String fileName, String s,TreeMap<String,String>tempMap) throws Exception
	{
		  JSONParser parser = new JSONParser();  
	      Object obj = parser.parse(s);  
		  
		   JSONObject jsonObject = (JSONObject) obj;  
		  
		   JSONArray fields=(JSONArray) jsonObject.get("fields");
		   LinkedHashMap<String, String> tableObject =new LinkedHashMap<String, String>();
		   Iterator< JSONObject > iterator = fields.iterator();  
		  StringBuilder query=new StringBuilder();
		  query.append("create table "+App.db+"."+fileName+" ( "); 
		   String template= "insert into "+App.db+"."+fileName+"( ";
		   
		   boolean flag=false;
		   if(iterator.hasNext())
		   {
			   flag=true;
			   JSONObject jj= (JSONObject)iterator.next();
			   //System.out.println(jj.get("label")+" "+jj.get("type"));
			   tableObject.put((String)jj.get("label"), (String)jj.get("type"));
			   String t=(String)jj.get("type");
			   if(t.equals("number"))
				   t="double";
			   else if(t.equals("boolean"))
				   t="boolean";
			   else if(t.equals("array"))
				   t="array";
			   else
				   t="text";
			   
			   query.append("`"+jj.get("label")+"` "+t+" ,");
			   template+="`"+jj.get("label")+"`, ";
			   tempMap.put(jj.get("label").toString(),t);
		   }
	
		   while (iterator.hasNext()) { 
			  
			   JSONObject jj= (JSONObject)iterator.next();
			   //System.out.println(jj.get("label")+" "+jj.get("type"));
			   tableObject.put((String)jj.get("label"), (String)jj.get("type"));
			   String t=(String)jj.get("type");
			   if(t.equals("number"))
				   t="double";
			   else
				   t="text";
			   query.append("`"+jj.get("label")+"` "+t+" ,");
			   template+="`"+jj.get("label")+"`, ";

			   tempMap.put(jj.get("label").toString(),t);
		   }  
		   if(flag)
		   {
			  		   query.deleteCharAt(query.length()-1).append(" )");
		   Statement stmt=App.connect.createStatement();
		  System.out.println("query:"+query);
		   if(stmt.execute(query.toString()))
		   {
			   return false;
			   }
		   else
		   {
			
		   
		   query.setLength(0);
		   JSONArray data=(JSONArray) jsonObject.get("data");
		   Iterator< JSONArray > iterator1 = data.iterator();
		  
		   template=template.substring(0,template.length()-2)+") values (";
		   //template+=") values ( ";
		int i=0;
		//String query1="";
		boolean flag1=false;
		  stmt=App.connect.createStatement();
		   while (iterator1.hasNext()) { 
			   JSONArray jj= (JSONArray)iterator1.next();
				  StringBuilder sb=new StringBuilder(jj.toString());
				  sb.deleteCharAt(0);
				  sb.deleteCharAt(sb.length()-1);
				  String ss=sb.toString();
				
				 stmt.addBatch(template+ss+" );");
				 if(i==5)
				 {
					int arr[]=stmt.executeBatch();
					
					for(int kk: arr)
						if(kk<0)
							return false;
					i=0;
					 stmt=App.connect.createStatement();
					 flag1=false;
					
				
				}
				else
				{
					flag1=true;
					i++;
				}
			}
		   if(flag1)
		   {
				int arr[]=stmt.executeBatch();
				
				for(int kk: arr)
					if(kk<0)
						return false;   
		   }
		   }
		   }
		   return true;
		   
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
	
	}

	

}