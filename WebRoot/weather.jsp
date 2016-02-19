<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>weather.jsp</title>
	</head>
	<body>

		<font color="red">
			地点：${list[1]}<br/>
			检测时间：${list[3]}<br/>
			实时天气：${list[4]}<br/>
			紫外线强度：${list[5]}<br/>
		</font>
		
	</body>
</html>