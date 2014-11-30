<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ReadMore@Cool Web</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="icon" href="images/icon4.gif" type="image/x-icon" />
<link href="style.css" rel="stylesheet" type="text/css" />
  
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<div id="bodyPan">
  <div id="leftPan">
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
    </p></li>
    <li >Provides you with a resources, query and response module
    <p>
    In this module, we have three further subparts. In resources, any general user can see the information of all the tables and the columns we have in our database. This helps the user to make a query at query subparts.
   In query, users have a dropdown driven and selections to make their query and ask for the relevant data that they want.
   In reponse, we present the user with the relevant data that is data is being served.
   </p></li>
   <li >Provides you with an API support
    <p>
   Users can use our system as an API that follows the REST API guidelines. It exposes the <span>Data as a Service</span> and servesit in <span>json format.</span>
   </p></li>
   </ul>
    <p class="more"><a href="readmore.jsp">read more</a></p>
    
  </div>
 
</div>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
