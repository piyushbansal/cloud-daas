<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cool Web</title>
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
else
{
%>
<div id="bodyPan">
  <div id="leftPan">
  <label style="color:red"> 
  <%
  if(request.getAttribute("cerror")!=null)
	  out.println(request.getAttribute("cerror"));
  %>
  </label>
    <h2>who we are</h2>
    <p style="text-align:justify"><span>Data is the fuel that drives today's digital economy</span></p>
     <p style="text-align:justify">
     We are building another layer over the 
     <span>
     <a style="background:white; color: black; text-decoration: underline" href="http://www.data.gov.in" target="_blank">data.gov.in</a>
     </span>
      which is a open initiative by Indian government to provide its users with a varied kind of information categorized into various sectors. The information provided is in raw format.
    </p>
    <p>
    We're making it so that any application can tap into our data service and directly use the response that we provide them. 
    All that the end user has to do is feed the data into whatever applications they want.
    </p>
    <p>
    <span>Cool Web provides it's users with three main modules:</span>
    </p>
    <ul style="list-style-type: square">
    <li >Provides you with a manage module
    <p>
    In this module, an authorative person can upload the data files(i.e. json/csv etc) as tables into the database using our front end.
    </p>
    </li>
    
   </ul>
   </p>
    <p class="more"><a href="readmore.jsp">read more</a></p>
    
  </div>
 
</div>
<%@ include file="/WEB-INF/footer.jsp" %>
<%
}
%>
</body>
</html>
