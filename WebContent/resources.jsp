<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.TreeMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Resources@Cool Web</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="icon" href="images/icon4.gif" type="image/x-icon" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
if(session.getAttribute("dbInfoMap")==null)
{
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
}
else
{
%>
<%@ include file="/WEB-INF/header.jsp" %>

<div id="bodyPan">
  <div id="leftPan">
    <p style="color: #0099FF;font-size:25px"><span>The various resources(tables) in our db are:</span></p>
    
    <%
    
    TreeMap<String, TreeMap<String,String>> dbInfoMap =(TreeMap<String,TreeMap<String,String>>)session.getAttribute("dbInfoMap");
	TreeMap<String,String> temp;
	
	for(String tableName: dbInfoMap.keySet())
	{
		%>
		<div style=" margin: 10px;padding: 10px;border: solid 1px #0099FF; border-radius: 5px 5px; box-shadow: 5px 5px 3px #298200;">
		<span style="color: #0099FF;font-size:20px;"><b><%= tableName %></b></span>
		<%
		temp=dbInfoMap.get(tableName);
		%>
		<table style="color: #298200;font-size:15px;margin-top:5px;">
		<%
		for(String col: temp.keySet())
		{
			%>
			<tr>
			<td style="padding-left:5px;padding-top:5px;padding-right:20px;padding-bottom:5px;">
			<%= col %>
			</td>
		<td style="padding-left:5px;padding-top:5px;padding-right:20px;padding-bottom:5px;">
			<%= temp.get(col) %>
			</td>
			</tr>
			<%	
		}
		%>
		</table>
		</div>
		<%
	}
	
	
	
	
	
	
    %>
    
    
  </div>
</div>
<%@ include file="/WEB-INF/footer.jsp" %>
<%
}
%>
</body>
</html>
