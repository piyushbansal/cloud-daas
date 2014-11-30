
<div id="maintopPan">
  <div id="maintopPanOne">
    <div id="topHeaderPan"><img src="images/logo.jpg" title="Cool Web" alt="Cool Web" width="220" height="53" />
      <ul>
	<li><a href="index.jsp">Home</a></li>
	<li><a href="resources.jsp">Resources</a></li>
        <li><a href="query.jsp">Query</a></li>


<%
if(session.getAttribute("admin")!=null&&session.getAttribute("admin").equals("true"))
{
%>
        <li><a class="adminurl" href="manage.jsp">Manage</a></li>
<%
}
else
{
%>
	<li><a class="adminurl" href="login.jsp">Login</a></li>
<%
}
%>        
<li><a href="contact.jsp">Contact</a></li>
      </ul>  

    </div>
    <div id="topSidemenuPan">
      <ul>
        <li class="home"><a href="index.jsp">Home</a></li>
        <li class="contact"><a href="contact.jsp">Contact</a></li>
      </ul>
    </div>
  </div>
</div>

