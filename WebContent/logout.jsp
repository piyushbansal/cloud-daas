<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout@Cool Web</title>
</head>
<body>
<%

session.setAttribute("admin","false");
response.setStatus(response.SC_MOVED_TEMPORARILY);
response.setHeader("Location", "index.jsp"); 

%>
</body>
</html>