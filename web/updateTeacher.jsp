<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>更新老师</title>

<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

<style type="text/css">
.form-signin input[type="text"], .form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	/* 	margin-bottom: 15px; */
	padding: 7px 9px;
}

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
</style>

</head>
<body>
	<div class="container">

		<jsp:include page="header.jsp"></jsp:include>

		<form class="form-signin form-horizontal"
			action="updateTeacher?method=update" method="post">
			<div class="form-group">
				<label class="col-sm-3 control-label" for="tid">教师编号：</label>
				<div class="col-sm-9">
					<input type="text" name="tid" value="${teacher.tid }"
						readonly="readonly" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="tname">姓名：</label>
				<div class="col-sm-9">
					<input class="form-control" type="text" name="tname" id="tname"
						value="${teacher.tname }">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label" for="tsex">性别：</label>
				<div class="col-sm-9">
					<div class="checkbox">
						<input type="radio" name="tsex" value="男"
							${student.ssex eq '男'?'checked':'' }>男 <input
							type="radio" name="tsex" value="女"
							${student.ssex eq '女'?'checked':'' }>女
					</div>

				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label" for="ttel">电话： </label>
				<div class="col-sm-9">
					<input class="form-control" type="text" name="ttel" id="ttel"
						value="${teacher.ttel }">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label" for="taddress">地址：</label>
				<div class="col-sm-9">
					<input class="form-control" type="text" name="taddress" id="taddress"
						value="${teacher.taddress }">
				</div>
			</div>
			<div class="text-center">
				<input type="submit" value="提交" class="btn btn-primary">&nbsp;&nbsp;
				<input type="button" class="btn btn-success"
					onclick="window.location.href='main.jsp'" value="返回">
				</div>
		</form>




	</div>
</body>
</html>