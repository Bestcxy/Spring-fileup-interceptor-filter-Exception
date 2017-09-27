<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/home.js"></script>
<script type="text/javascript" src="js/ajaxfile.js"></script>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<h1>·文件上传成功</h1>
	<a href="<%=basePath%>home">首页</a>
	<br>
	
	<h1>·异常测试</h1>
	<a href="<%=basePath%>exception">测试框架异常机制</a>
	<br>
	
	<h1>·文件上传</h1>
	<form method="post" action="<%=basePath%>fileup" enctype="multipart/form-data">
		<input type="file" name="file1" />
		<input type="submit" value="提交"/>
	</form>
	<br>
	
	<h1>·restful接口get方式访问测试</h1>
	<a href="<%=basePath %>restfulGetResponseBody">restful get方式访问测试,@ResponseBody</a><br>
	<a href="<%=basePath %>restfulGetNoResponseBody">restful get方式访问测试,全局配置</a>
	<br>
	
	<h1>Spring ajax测试</h1>
	测试描述：在文本框中输入任意内容，鼠标离开后显示提示信息，当输入“123”时,提示数据尚不存在，其他字符提示数据已存在<br>
	<br>
	输入信息并移开鼠标：<input class="checkUserName" id="userName" name="userName" type="text">
	<span class="col_msgspan"></span>
	
	<h1>Spring ajax 提交文件</h1>
	<input type="file" name="ajaxfile" id="ajaxfile"/>
	<input type="submit" value="提交" id="ajaxfilesubmit"/>
</body>
</html>