<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加班级</title>

<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

<style type="text/css">
.form-signin {
	max-width: 500px;
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
	margin-bottom: 20px;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

/* .form-signin input[type="text"], .form-signin input[type="password"] {
	font-size: 12px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
} */
</style>
</head>
<body>
	<div class="container">
	
		<jsp:include page="header.jsp"></jsp:include>

	
		<form class="form-signin" action="addClass" method="post"
			name="myform">
			<table class="table" width="100%">
				<tr>
					<td>编号：</td>
					<td><input class="form-control" type="text" name="classId" 
						placeholder="请输入编号"></td>
				</tr>
				<tr>
					<td>班名：</td>
					<td><input class="form-control" type="text" name="cclasname" 
						placeholder="请输入班名"></td>
				</tr>
				<tr>
					<td>班主任：</td>
					<td><input class="form-control" type="text" name="teachername"
						placeholder="不可输入班主任" id="sssa1"></td>
				</tr>
			</table>
			<div class="text-center">
			<input type="submit" value="提交" class="btn btn-primary">
			&nbsp;&nbsp;&nbsp; <input type="button"
				onclick="window.location.href='main.jsp'" value="返回"
				class="btn btn-success"></div>
			<div class="text-center" style="color: red">${msg }</div>
		</form>

	</div>

</body>

<script type="text/javascript">

	document.getElementById("sssa1").value = null;
	document.getElementById("sssa1").disabled = true;

</script>
</html>