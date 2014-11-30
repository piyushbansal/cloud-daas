package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;

import util.utility;

@Path("/queryapi")
public class QueryResource {
  // This method is called if XMLis request
  @GET
  @Produces({ MediaType.APPLICATION_JSON })
  public Response getXML(@QueryParam("submitquery") String submitquery) {
System.out.println("sdsgdsgdhgdsgdgsdgds called");
	  String returnString="";
	  JSONArray jsonarray=new JSONArray();
	  if(submitquery==null)
	  {
		 return Response.status(404).entity("Error: provide submitquery for this search").build();
	  }
	  try
	  {
	  System.out.println("huraay");
		  ResultSet rs=utility.queryDb(submitquery);
		  if(rs==null)
		  {
			  return Response.status(404).entity("Error:invalid query").build();
		  }
		  System.out.println("converting");
		  jsonarray=utility.convertToJson(rs);
		  System.out.println("converted");
	  }
	  catch(SQLSyntaxErrorException e)
	  {
		  return Response.status(404).entity("Error:invalid query").build();
	  }
	  catch(SQLException e)
	  {
		  return Response.status(404).entity("Error:invalid query").build();
	  }
	  catch(Exception e)
	  {
		  return Response.status(500).entity("Error:server error").build();
	  }
	  return Response.ok(jsonarray.toString()).build();
  }
  
  // This can be used to test the integration with the browser
  @GET
  @Produces({ MediaType.TEXT_XML })
  public QueryApi getHTML() {
	  System.out.println("sdhsdgshdsdfsfdsgjdfhdfhdsfin browser");
	  QueryApi todo = new QueryApi();
	    TodoObject tt[]=new TodoObject[2];
	    tt[0]=new TodoObject();
	    tt[1]=new TodoObject();
	    
	    tt[0].setLabel("l1");
	    tt[0].setType("t1");
	    tt[1].setLabel("l2");
	    tt[1].setType("t2");
	    todo.setTodoobj(tt);
	    String arr[]=new String[2];
	    arr[0]="\"abc\",\"bcd\"";
	    arr[1]="\"xyz\",\"efg\"";
	    todo.setData(arr);
	    return todo;
  }

} 
