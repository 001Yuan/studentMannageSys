<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    <c:if test="${user==null }">
    	 <c:redirect url="/login.jsp"></c:redirect>
    	
    </c:if>
    
    <div class="row-fluid">
			<div class="span12">
				<div class="head">
					<div class="headLeft">
						<h2>教学管理系统</h2>
					</div><br/>
					<div class="headRight">
						欢迎<c:if test="${user.type==1}">管理员：</c:if>
						<c:if test="${user.type==2}">学生：</c:if>
						<c:if test="${user.type==3}">老师：</c:if>
						<font color="blue">${user.username }</font>
					</div>
				</div>
			</div>
	</div> 
	<div class="row-fluid">
	
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="main.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 首页</a>
			    </div>
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			      <c:if test="${user.type==1}">
			        <li><a href="listTeacher"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 管理老师信息</a></li>
			        <li><a href="listStudent"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 管理学生信息</a></li>
			        <li><a href="listClass"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 管理班级信息</a></li>
			        <li><a href="listCourse"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 管理课程信息</a></li>
			        <li><a href="listAchievement"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 管理成绩信息</a></li>
			        <li><a href="updatepw.jsp"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> 修改密码</a></li>
			        <li><a href="exit" onclick="return exitSys()"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 退出系统</a></li>
			      </c:if>
			      <c:if test="${user.type==2}">
			      <li><a href="listCourse"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 选课</a></li>
			        <li><a href="listAchievement"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 查看课程/成绩</a></li>
			        <li><a href="updatepw.jsp"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> 修改密码</a></li>
			        <li><a href="exit" onclick="return exitSys()"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 退出系统</a></li>
			      </c:if>
			      <c:if test="${user.type==3}">
				      <li><a href="listCourse"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 查看课程信息</a></li>
				      <li><a href="listAchievement"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> 管理学生成绩</a></li>
				      <li><a href="updatepw.jsp"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> 修改密码</a></li>
				      <li><a href="exit" onclick="return exitSys()"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 退出系统</a></li>
			      </c:if>
			      </ul>
			    </div>
			  </div>
		</nav>
			<script type="text/javascript">
				function exitSys(){
					return window.confirm("确定要退出系统吗?");
				}
			</script>
		</div>