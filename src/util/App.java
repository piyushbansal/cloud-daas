package util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.TreeMap;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;



public class App {
	
	
    public static Connection connect = null;
    public static MysqlDataSource ds = null;
    public static  TreeMap<String, TreeMap<String,String>> dbInfoMap = null;
    public static TreeMap<String,String> temp=new TreeMap<String,String>();
    public static TreeMap<String,String> adminMap=null;
    private static String url,user,passwd;
    public static String db="cloud";
    static
	{
	        try {
//	        	Class.forName("com.mysql.jdbc.driver");
	            // Create a new DataSource (MySQL specifically)
	            // and provide the relevant information to be used by Tomcat.
	            
	            url="jdbc:mysql://localhost:3306/"+db;
	            user="root";
	            passwd="root";
	            ds = new MysqlDataSource();
	            ds.setUrl(url);
	            ds.setUser(user);
	            ds.setPassword(passwd);
	            //System.out.println("Driver");
	            connect=ds.getConnection();
	           // connect = DriverManager.getConnection(url,user,passwd);
	            //System.out.println("connected");
	        } 
	        catch (Exception e)
	        {
	        	e.printStackTrace();
	        } 
     }
	 public static  void dbInfo() throws Exception
		{
			try
			{
				
		   dbInfoMap=new TreeMap<String,TreeMap<String,String>>();
		   
		   String query1 = "select table_name from information_schema.tables where table_schema='"+db+"';";
		   ResultSet rs=null;
		   ResultSet rs2=null;
		   ResultSetMetaData meta=null;
		   int c=0;
		   Statement stmt2=connect.createStatement();
		   Statement stmt=connect.createStatement();
		   String tempTableName="";
		   String query2="";
		   String col,datatype;
		   rs=stmt.executeQuery(query1);
		   while (rs.next())
			{
				  tempTableName= rs.getString(1);
				  query2="select * from "+db+"."+tempTableName+" limit 1;";
			
				  if(tempTableName.equals("admin"))
				  {
					  query2="select username,password from "+db+"."+tempTableName+";";
					  rs2=stmt2.executeQuery(query2);
					  adminMap=new TreeMap<String, String>();
					  while(rs2.next())
					  {
						
						  adminMap.put(rs2.getString(1),rs2.getString(2));
					  }
					  
				  }
				  else
				  {
					  rs2=stmt2.executeQuery(query2);
				  meta = rs2.getMetaData();
				  c=meta.getColumnCount();
				  for(int j=1;j<=c;j++)
				  {
					  col=meta.getColumnName(j);
					  datatype=meta.getColumnClassName(j);
					  datatype=datatype.substring(datatype.lastIndexOf(".")+1,datatype.length());
					  temp.put(col,datatype);
				  }
				  dbInfoMap.put(tempTableName, temp);
				  temp=new TreeMap<String,String>();
				  }
			 }
			}catch (Exception e)
			{
				
				dbInfoMap=null;
				adminMap=null;
				throw e;
			}
		 
		 
		  
		}  
	}