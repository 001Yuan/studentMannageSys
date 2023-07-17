<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>用户登录</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<style type="text/css">
			body {
				text-align: center;
				background-color: whitesmoke;
				
			    background-image:url(images/background.jpg);
			
			}
			
			#formdiv {
				width: 460px;
				height: 320px;
				margin: 0 auto;
				background: white;
				margin-top: 10%;
				border: 1px solid #888;
				border-radius: 10px;
			}
			#formdiv2{
				padding: 20px;
			}
			#codeImg{
				margin-top: 10px;
			}
		</style>
	</head>

	<body>

		<div id="formdiv">
			<div style="padding-top: 10px;">
				<h2>教学管理系统</h2>
			</div>
			<div id="formdiv2">
			<form class="form-horizontal" action="loginservlet" method="post" onsubmit="return checkform();">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" >
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword4" class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="validateCode" name="validateCode" placeholder="请输入验证码">
					</div>
					<img id="codeImg" src="codeservlet" /><a href="javascript:void(0)" onclick="changeImg()">看不清?</a>
				</div>

				<div class="form-group">
					<div class="col-sm-12">
						<input type="submit" class="btn btn-success" value="登录"/>
						&nbsp;&nbsp;
						<input type="reset" class="btn btn-danger" value="重置" />
					</div>
				</div>
			</form>
			</div>
		</div>
	<script type="text/javascript">
		function changeImg() {
			$("#codeImg").attr("src","codeservlet?number="+Math.random());
		}
		//检查用户名
		function checkUserName(){
			//$(obj).html(); 获取标签中的内容
			//$(obj).text(); 获取标签的文本
			//$(obj).val();//获取标签的value属性内容
			
			var username=$("#username").val();
			//alert(username);
			if(username==null||username.trim()==""){
				alert("请输入用户名");
				return false;
			}
			return true;
		}
		//检查密码
	 	function checkPassword(){
			var password=$("#password").val();
			if(password==null||password.trim()==""){
				alert("请输入密码");
				return false;
			}
			return true;
		} 
		//检查验证码
		function checkCode(){
			var code=$("#validateCode").val();
			if(code==null||code.trim()==""){
				alert("请输入验证码");
				return false;
			}
			return true;
		} 
		//检查表单
		function checkform(){
			//alert("xxxx检查表单");
			if(!checkUserName()){
				return false;
			}
			if(!checkPassword()){
				return false;
			}
			if(!checkCode()){
				return false;
			}
			
			return true;
		}
	</script>
	</body>

</html>