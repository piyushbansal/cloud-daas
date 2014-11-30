<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manage@Cool Web</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="icon" href="images/icon4.gif" type="image/x-icon" />
<link href="style.css" rel="stylesheet" type="text/css" />
 </head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<%
if(request.getAttribute("cerror")==null && session.getAttribute("dbInfoMap")==null)
{
    response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index"); 
}
else if(session.getAttribute("admin")!=null&&((String)session.getAttribute("admin")).equals("false"))
{
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
}
else
{
%>
	

<div id="bodyPan">
  <div id="leftPan">
  <a style="padding:10px;background:white;color:blue;text-decoration:underline;" href="logout.jsp">Logout</a>
  <label style="padding:10px;color:red"> 
  <%
  if(request.getAttribute("cerror")!=null)
	  out.println(request.getAttribute("cerror"));
  %>
  </label>
 <form style="margin:20px;" action="manage" method="POST" enctype="multipart/form-data">
  <label style="color:#0099FF">Upload:(*.json)</label> <input type="file" name="table" >
  <input type="submit" value="Upload">
</form> 
  </div>
 
</div>
<%@ include file="/WEB-INF/footer.jsp" %>
<%
}
%>
</body>
</html>
