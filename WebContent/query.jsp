<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.TreeMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Query@Cool Web</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="icon" href="images/icon4.gif" type="image/x-icon" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script>
var mapByIndex =new Array();
</script>
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
    <p>
    <span style="color: #0099FF;font-size:20px">Form your query here:</span>
    <br/>
    <br/>
    <span style="color: #298200;font-size:15px">The general pattern is "select &lt;cols&gt; from &lt;tableName&gt; &lt;&lt;where &lt;condition1 and condition2...&gt; &gt;&gt; &lt; group by/order by/having &gt;"
    </span>
    </p>
    <label id="cerror" style="color:red;padding:10px;">
    <%
    if(request.getAttribute("cerror")!=null)
    	out.println(request.getAttribute("cerror"));
    %></label>
    
    <%
    
    TreeMap<String, TreeMap<String,String>> dbInfoMap =(TreeMap<String,TreeMap<String,String>>)session.getAttribute("dbInfoMap");
	TreeMap<String,String> temp;
	%>
	
	<div style=" margin-left:10px; margin-top:0px;margin-bottom:10px;padding-bottom:20px;padding-left: 10px;padding-top:0px;">
	
	<span style="color: #0099FF;font-size:15px">Select the table:</span>
	
	 <select id="tableSelect" onchange="populateColsFunc(this.selectedIndex)">
	 <option selected value="--Select Table--">--Select Table--</option>
	<%
	for(String tableName: dbInfoMap.keySet())
	{
		%>
		
 		 <option value="<%=tableName%>"><%=tableName%></option>
 		 <%
 		 out.println("<script>");
		 StringBuilder sb=new StringBuilder();
		 sb.append("[");
 	
 		 for(String col: dbInfoMap.get(tableName).keySet())
 		 {
 			 sb.append("\""+col+"\",");
 		 }
 		 sb.deleteCharAt(sb.length()-1);
 		 sb.append("]");
 		 out.println("mapByIndex.push("+sb+")</script>");
 	}
	%>
	</select> 
	</div>
	<div id="cols" style="display:none;margin-left:10px; margin-top:0px;margin-bottom:10px;padding-bottom:20px;padding-left: 10px;padding-top:0px;">
	<span style="color: #0099FF;font-size:15px">Select the columns from the above selected table:</span><br>
	<input type="checkbox" id="selectallc" value="Select All(*)" onclick="selectall()"/>Select All(*)
	</div>
	<script>
	
	function selectall()
	{
		value=false;
		value=document.getElementById("selectallc").checked;
		
		checkboxes = document.getElementsByName('cc');
	    
    	var boxes="";
    	for(var temp=0;temp<checkboxes.length;temp++)
    	{
    	
    	 checkboxes[temp].checked=value;
    	 if(value==true)
    	
    		 boxes=boxes+"`"+checkboxes[temp].value+"`,";
    	 
    	}
    	if(boxes=="")
    		{
    	 	
    		document.getElementById("colSpan").value="*";
    		}
    	else
    	{
    	
    	 	boxes=boxes.substring(0,boxes.length-1);
    	  	document.getElementById("colSpan").value=boxes;
    	}
	}
function populateColsFunc(index)
{
	document.getElementById("finalbutton").disabled=false;
	//alert(index);

	// var element = document.getElementById("deldiv");
	 //alert(element.length);
	 
	 //for (index = element.length - 1; index >= 0; index--) {
	
	//	 alert("in");
	//if(element)
	//{
		//alert("in");
	//element.parentNode.removeChild(element);
	//}
	 //}
   //alert("out");
	 

    var cols=mapByIndex[index-1];
   //alert(cols);
    var div = document.createElement('div');
    div.id="deldiv";
    for(var i=0;i<cols.length;i++)
    {
  
	    var checkbox = document.createElement('input');
	    checkbox.type = "checkbox";
	    checkbox.name = "cc"
	    checkbox.value = cols[i];
	    checkbox.id = "c"+cols[i];
	    checkbox.onclick = function() { 
	    	
	    	checkboxes = document.getElementsByName('cc');
	    
	    	var boxes="";
	    	for(var temp=0;temp<checkboxes.length;temp++)
	    	{
	    	
	    	 if(checkboxes[temp].checked==true)
	    	{	
	    	
	    		 boxes=boxes+"`"+checkboxes[temp].value+"`,";
	    	 }
	    	}
	    	if(boxes=="")
	    		{
	    	 	
	    		document.getElementById("colSpan").value="*";
	    		}
	    	else
	    	{
	    	
	    	 	boxes=boxes.substring(0,boxes.length-1);
	    	  	document.getElementById("colSpan").value=boxes;
	    	}
	    };
	    //checkbox.style.cssText="padding:5px";
	    var label = document.createElement('label')
	    label.id = "l"+cols[i];
	    label.style.cssText="padding-right:10px";
	    label.appendChild(document.createTextNode(cols[i]));
	    div.appendChild(checkbox);
	    div.appendChild(label);
	   
	//alert(cols[i]) ; 
    }
	document.getElementById("cols").appendChild(div);
	document.getElementById("cols").style.display="block";
	document.getElementById("where").style.display="block";
	document.getElementById("tableSelect").disabled=true;
	var tableName=document.getElementById("tableSelect").options[index].value;
	document.getElementById("tableSpan").value=tableName;
	
}
function reset1()
{
	//alert("fdfdfdfdf");
	var element = document.getElementById("deldiv");
	if(element)
	{
		element.parentNode.removeChild(element);
	}	
	for(var abc=0;abc<=xx;abc++)
		{
		var str="seldiv"+abc;
		var element = document.getElementById(str);
		if(element)
		{
			element.parentNode.removeChild(element);
		}	
		}
	document.getElementById("cols").style.display="none";
	document.getElementById("tableSelect").disabled=false;
	document.getElementById("where").style.display="none";
	document.getElementById("tableSelect").selectedIndex=0;
	document.getElementById("finalbutton").disabled=true;
	document.getElementById("cerror").innerHTML="";
	document.getElementById("tableSpan").value="";
	document.getElementById("tableSpan").placeholder="<table>";
	document.getElementById("colSpan").value="*";
	document.getElementById("whereSpan").placeholder=" where/group by/order by/having <conditions> ";
	document.getElementById("whereSpan").value="";
}

</script>
<div id="where" style="display:none;margin-left:10px; margin-top:0px;margin-bottom:10px;padding-bottom:20px;padding-left: 10px;padding-top:0px;">
	
<a href=# style="color:black;background:white;text-decoration:underline" onclick="addwhere()">Add Where</a>
</div>
<script>
var xx=0;
var flag=false;
function addwhere()
{
	
	var index=document.getElementById("tableSelect").selectedIndex;

	 

    var cols=mapByIndex[index-1];
 // alert(cols);
   var div2 = document.createElement('div');
    
    var select=document.createElement('select');
    select.id="whereid"+xx;
    
    var option=document.createElement('option');
    option.value='--Select cols--';
    option.text='--Select cols--'
    select.appendChild(option);
   div2.id="seldiv"+xx;
    for(var i=0;i<cols.length;i++)
    {
  	    var option = document.createElement('option');
	    option.value=cols[i];
	    option.text=cols[i];
	  
	    select.appendChild(option);
	    
	   
	
    }
//    alert("dfgdfjghgfdhgjdf");
	
	//document.getElementById("where").style.display="block";
	
	var label = document.createElement('label');
	label.style.cssText="padding-left:15px;padding:right:15px;";
	label.appendChild(document.createTextNode("your condition:"));
	var textbox=document.createElement("input");
	textbox.type="text";
	textbox.id="wherecond"+xx;
	textbox.placeholder="<operator value>";
	
	var href=document.createElement("a");
//	alert("gfghhtyhgds");
	href.href="#";
	href.id="href"+xx;
//	alert("gfgds");
	href.appendChild(document.createTextNode("[ OK ]"));
	href.style.cssText="padding-left:15px;padding-right:15px;color:blue;background:white;";
	href.onclick = function() { 
	//	alert(xx);
		hrefid="href"+xx;
		//alert(hrefid);
		colid="whereid"+xx;
	//	alert(colid);
		wherecondid="wherecond"+xx;
	//	alert(wherecondid);
    	hrefq=document.getElementById(hrefid);
    //	alert("jj");
    	colq = document.getElementById(colid);
    //	alert("jj1");
    	condq=document.getElementById(wherecondid);
//alert("jj2");
    	span=document.getElementById("whereSpan");
    //	alert("jxzasxdvbnhjm");
    	document.getElementById("ok"+xx).style.pointerEvents="auto";
    if(!flag)
    	{
    //	alert(colq.selectedIndex);
    	var xyz=condq.value;
    	var abc=colq.options[colq.selectedIndex].value;
    	var s = "`"+abc+"` "+xyz;
    	//alert(s);
     	document.getElementById("whereSpan").value="where "+s;//colq.options[colq.selectedIndex].value+condq.value;
     	flag=true;
    	}
    else
    	{
    	
    //alert("old");
    document.getElementById("whereSpan").value+=" and `"+colq.options[colq.selectedIndex].value+"`"+condq.value;
    	}
    colq.disabled=true;
    condq.disabled=true;
    hrefq.style.pointerEvents="none";
    xx=xx+1;
   // alert("end");
     	
    };
	var href1=document.createElement("a");
	href1.href="#";
	href1.id="ok"+xx;
	href1.appendChild(document.createTextNode("[+]"));
	href1.style.cssText="pointer-events:none;padding-left:15px;padding-right:15px;color:blue;background:white;";

	
	href1.onclick = function()
	{
		addwhere();
	}
	div2.appendChild(select);
	div2.appendChild(label);
	div2.appendChild(textbox);
	div2.appendChild(href);
	div2.appendChild(href1);
	//alert("gfgds");
	document.getElementById("where").appendChild(div2);
	//alert("gzZTYVCX");
	
}

function submit11()
{
	//alert("in");
	var table=document.getElementById("tableSpan").value;
	//alert("1");
	var col=document.getElementById("colSpan").value;
	//alert("2");
	var where=document.getElementById("whereSpan").value;
	
	//alert("3");
	var keyspace=document.getElementById("keyspace").value;
	
	//alert("4");
	var wherecheck=false;
	//alert("gfdfbvdgv");
	if(""==where)
		wherecheck=false;
	else
		{
		
		wherecheck=true;
		}
	var gg=document.getElementById("submitquery").value;
	//alert(gg);
	gg=gg+"select"+" "+col+ " from "+keyspace+"."+table;
	//alert(gg);

	//alert("here");
	if(wherecheck==true)
		{
		gg+=" "+where+";";
		}
	document.getElementById("submitquery").value=gg;
	}
</script>
	<p>Query formed so far is:<br>
	<label id="querysubmit">Select <input type="text" id="colSpan" value="*"/> 
	from <input type="text" id="tableSpan" value="" placeholder="&lt;table&gt;"/> 
	 <input type="text"  id="whereSpan" style="width: 350px;" placeholder="where/group by/order by/having &lt;conditions&gt;" value=""/>
	</label>
	</p>
	<form method="GET" action="query">
	<input type="text" hidden="hidden" name="submitquery" id="submitquery" value="" /> 
	<input type="text" hidden="hidden" id="keyspace" value="<% if(session.getAttribute("keyspace")!=null) 
	out.print(session.getAttribute("keyspace"));
	else
	out.print("");%>"/>
	<button style="margin-left:20px;" type="button" onclick="reset1()">Reset</button>&nbsp;&nbsp;&nbsp;
	
	<button style="margin-left:20px;" type="submit" id="finalbutton" disabled onclick="submit11()">Submit</button><br><br>
	</form>  
  </div>
</div>
<%@ include file="/WEB-INF/footer.jsp" %>
<%
}
%>
</body>
</html>
