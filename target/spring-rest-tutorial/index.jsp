
 <%
 	String contextPath = request.getContextPath();
 	String home = contextPath+"/home.action";
   %>
<head>
	<title></title>
	<meta content="1; url=<%= home %>" http-equiv="refresh" />
</head>

<body onload="javascript:location.replace('<%= home %>')">

</body>

</html>