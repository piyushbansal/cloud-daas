package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class utility {
	public static ResultSet queryDb(String query) throws SQLException,SQLSyntaxErrorException, Exception
	{
		Statement stmt=App.connect.createStatement();
		query=query.replaceAll("&lt;","<");
		query=query.replaceAll("&le;","<=");
		query=query.replaceAll("&gt;",">");
		query=query.replaceAll("&ge;",">=");
		System.out.println(query);
		
		ResultSet rs= null;
		rs=stmt.executeQuery(query);
		ResultSetMetaData meta;
		if(rs==null)
		{
			 return null;
		}
		
		return rs;
		
		}
		

	public static JSONArray convertToJson(ResultSet rs) throws Exception 
	{
		
		// TODO Auto-generated method stub
		JSONArray ar=new JSONArray();
		ResultSetMetaData meta=rs.getMetaData();
		
		int colCount=meta.getColumnCount();
		while(rs.next())
		{
			JSONObject obj=new JSONObject();
			for(int i=1;i<=colCount;i++)
			{
				String colName=meta.getColumnName(i);
				if(meta.getColumnType(i)==java.sql.Types.ARRAY)
				{
					obj.put(colName, rs.getArray(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.BIGINT)
				{
					obj.put(colName, rs.getInt(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.BOOLEAN)
				{
					obj.put(colName, rs.getBoolean(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.BLOB)
				{
					obj.put(colName, rs.getBlob(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.DOUBLE)
				{
					obj.put(colName, rs.getDouble(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.FLOAT)
				{
					obj.put(colName, rs.getFloat(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.INTEGER)
				{
					obj.put(colName, rs.getInt(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.VARCHAR)
				{
					obj.put(colName, rs.getString(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.TINYINT)
				{
					obj.put(colName, rs.getInt(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.SMALLINT)
				{
					obj.put(colName, rs.getInt(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.NUMERIC)
				{
					obj.put(colName, rs.getBigDecimal(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.TIMESTAMP)
				{
					obj.put(colName, rs.getTimestamp(colName));
				}
				else if(meta.getColumnType(i)==java.sql.Types.DATE)
				{
					obj.put(colName, rs.getDate(colName));
				}
				else 
				{
					obj.put(colName, rs.getObject(colName));
				}
			}
			ar.add(obj);
				
			}
		return ar;
		
	}

}
