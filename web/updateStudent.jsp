<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>更新学生</title>

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
</style>

</head>
<body>
	<div class="container">

		<jsp:include page="header.jsp"></jsp:include>

		<form class="form-signin form-horizontal"
			action="updateStudent?method=update" method="post">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="sid">学号：</label>
				<div class="col-sm-10">
					<input type="text" name="sid" value="${student.sid }"
						readonly="readonly" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="sname">姓名：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="sname" id="sname"
						value="${student.sname }">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="ssex">性别：</label>
				<div class="col-sm-10">
					<div class="checkbox">
						<input type="radio" name="ssex" value="男"
							${student.ssex eq '男'?'checked':'' }>男 <input
							type="radio" name="ssex" value="女"
							${student.ssex eq '女'?'checked':'' }>女
					</div>

				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="sage">年龄：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="sage" id="sage"
						value="${student.sage }">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="stel">电话： </label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="stel" id="stel"
						value="${student.stel }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="sdept">系别：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="sdept" id="sdept"
						value="${student.sdept }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="sclas">班级：</label>
				<div class="col-sm-10">
					<select class="form-control" name="sclas">
						<c:forEach items="${aaaa}" var="aaaa">
							<option value="${aaaa.cclasname }">${aaaa.cclasname }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="saddress">地址：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="saddress" id="saddress"
						value="${student.saddress }">
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