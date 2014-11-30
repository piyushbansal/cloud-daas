<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login@Cool Web</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="icon" href="images/icon4.gif" type="image/x-icon" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
if(session.getAttribute("admin")!=null && session.getAttribute("admin").equals("true"))
{
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "manage.jsp"); 
	
}
else
{
%>
<%@ include file="/WEB-INF/header.jsp" %>

<div id="bodyPan">
  <div id="leftPan">
   
    
		
		<div style=" margin-left: 200px;margin-bottom:50px; width:400px;padding: 10px;">
	
	<fieldset style="border: solid 1px #0099FF; border-radius: 5px 5px; box-shadow: 5px 5px 3px #298200;" id="cfieldsetlogin">
		<legend style="color:#0099FF;font-size:20px;"><b>LOGIN</b></legend>
<form action="login" method="POST">
 <table>
 	    <tr><td colspan=2><label style="color:red">

<%
if(request.getAttribute("cerror")!=null)
	out.println(request.getAttribute("cerror"));
else 
	out.println();
%>
 </label></td></tr>
		<tr><td>Username: </td><td><input type="text" id="username" name="username" required placeholder="<username>" ><span class="star" style="color:red">*</span><br/></td>
		</tr><tr><td>Password: </td><td><input type="password" id="password" name="password" required placeholder="<password>" ><span class="star" style="color:red">*</span>
		<br/></td></tr>
		<tr><td></td><td><button type="submit">Login</button> </td></tr>
		
</table>

</form>
		</fieldset>
	
	
	
	
	</div>  
  
  </div>
</div>
<%@ include file="/WEB-INF/footer.jsp" %>
<%
}
%>
</body>
</html>
