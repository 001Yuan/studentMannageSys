<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>更新成绩</title>

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
			action="updateAchievement?method=update" method="post">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="achievementid">序号：</label>
				<div class="col-sm-10">
					<input type="text" name="achievementid" value="${achievement.achievementid }"
						readonly="readonly" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="stuid">姓名：</label>
				<div class="col-sm-10">
				
					<c:forEach items="${student}" var="student">
						<c:if test="${achievement.stuid==student.sid}">
							<input class="form-control" type="text" value="${student.sname }" readonly="readonly">
						</c:if>
					</c:forEach>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="coursename">课名：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="coursename" id="coursename"
						value="${achievement.coursename }" readonly="readonly">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="achievement">分数：</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="achievement" id="achievement"
						value="${achievement.achievement }" oninput="if(value<0)value=0;if(value>100)value=100">
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