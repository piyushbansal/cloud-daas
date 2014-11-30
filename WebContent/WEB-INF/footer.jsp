<div id="footermainPan" style="boder-bottom:  solid 3px #0099FF; border-radius: 5px 5px; box-shadow: 10px 10px 5px #84e003; ">
  <div id="footerPan"> <a href="#"><img src="images/footerlogo.gif" title="Cool Web" alt="Cool Web" width="218" height="52" border="0" /></a>
    <ul>
      <li><a href="index.jsp">Home</a> | </li>
      <li><a href="resources.jsp">Resources</a> | </li>
      <li><a href="query.jsp">Query</a> | </li>
     <%
if(session.getAttribute("admin")!=null&&session.getAttribute("admin").equals("true"))
{
%>
        <li><a class="adminurl" href="manage.jsp">Manage</a> | </li>
<%
}else
{
	%><li><a class="adminurl" href="login.jsp">Login</a> | </li>
	<%
}
%>  
      <li><a href="contact.jsp">Contact</a> </li>
    </ul>
    <p class="copyright">&copy;cool web. All rights reserved.</p>
   
  </div>
</div>

