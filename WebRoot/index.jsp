<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		欢迎您: ${user}
		<a href="/login/login.html">登录 </a>
		<a href="/login/servlet/LogoutServlet">退出登录</a>
		<br />
		<br />
		<br />
		<a href="/login/servlet/WeatherCheck">查看天气</a>
		<%-- <form action="/login/servlet/WeatherCheck" method="get" accept-charset="utf-8">
			<input type="text" name="city">&nbsp;<input type="submit" value="查看天气">
		</form> --%>
	</body>
</html>
