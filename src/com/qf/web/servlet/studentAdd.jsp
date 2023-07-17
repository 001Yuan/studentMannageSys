<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息添加页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
span {
	color: red;
}


body {
	margin: 0;
	padding: 0;
}

.form-signin {
	max-width: 550px;
	padding: 19px 29px 29px;
	margin: 0 auto;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

table { /* max-width: 100%; */
	background-color: transparent;
	border-collapse: collapse;
	border-spacing: 0;
}

.table {
	width: 40%;
	margin-bottom: 20px;
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 12px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}

</style>
<script type="text/javascript">
	function inName(){
		var stName = document.myform.stName.value;
		if(stName == "请输入姓名"){
			document.myform.stName.value = "";
		}
	}
	function checkName(){
		var stName = document.myform.stName.value;
		if(stName == ""){
			alert("请输入姓名");
		}
	}
</script>
  </head>
  
  <body>
    		<form class="form-signin" action="addStudent" method="post" name="myform">
		<table >
				<tr>
					<td>
						姓名：
					</td>
					<td>
						<input class="input" type="text" name="stName" value="请输入姓名" onfocus="inName()" onblur="checkName()">
						
					</td>
				</tr>
				<tr>
					<td>
						性别：
					</td>
					<td>
						<input type="radio" name="stSex" value="男">
						男&nbsp;&nbsp;
						<input type="radio" name="stSex" value="女">
						女
						
					</td>
				</tr>
				<tr>
					<td>
						年龄：
					</td>
					<td>
						<input class="input" type="text" name="stAge">
					</td>
				</tr>
				<tr>
					<td>
						电话：
					</td>
					<td>
						<input class="input" type="text" name="stTel">
					</td>
				</tr>
				<tr>
					<td>
						系别：
					</td>
					<td>
						<input class="input" type="text" name="stDept">
						
					</td>
				</tr>
				<tr>
					<td>
						地址：
					</td>
					<td>
						<input class="input" type="text" name="stAddress">
						
					</td>
				</tr>
			</table>
			<input type="submit" value="提交" class="btn btn-primary">
			&nbsp;&nbsp;&nbsp;
			<input type="button" onclick="window.location.href='main.jsp'"
				value="返回" class="btn btn-success">
		</form>
  </body>
</html>
