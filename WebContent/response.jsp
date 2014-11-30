<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Response@Cool Web</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="icon" href="images/icon4.gif" type="image/x-icon" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%


%>
<%@ include file="/WEB-INF/header.jsp" %>

<div id="bodyPan">
  <div id="leftPan">
    <p style="color: #0099FF;font-size:25px"><span>The response to your query is:</span></p>
    
    <%
    if(request.getAttribute("response")==null){
    	response.setStatus(response.SC_MOVED_TEMPORARILY);
    	response.setHeader("Location", "index.jsp");
    }
    else
    {
 	 ArrayList<ArrayList<Object>> arrlist =(ArrayList<ArrayList<Object>>)request.getAttribute("response");
 	
 	%>
 	<label style="padding-top:-10px;padding-left:15px;color:#298200;">
 	<%
 	
 	if(request.getAttribute("query")!=null)
 	out.println(request.getAttribute("query"));
 	%>
 	</label>
 	<div style=" margin: 10px;padding: 10px;border: solid 1px #0099FF; border-radius: 5px 5px; box-shadow: 5px 5px 3px #298200;">
 	
<table id="table" style="color: #298200;font-size:15px;margin-top:5px;">
	<% for(ArrayList<Object> temp: arrlist)
	{
	
	%>
	<tr>
		
		<%
		for(Object col: temp)
		{
			%>
			
			<td style="padding-left:5px;padding-top:5px;padding-right:20px;padding-bottom:5px;">
			<%= col %>
			</td>
		<%
		}
		%>
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

</body>
</html>