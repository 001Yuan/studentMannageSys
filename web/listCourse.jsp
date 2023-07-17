<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>后台管理-课程列表</title>

		<link rel="stylesheet" href="css/bootstrap.css" />
		<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
<style type="text/css">
body{

    background-image:url(images/background.jpg);

}
</style>
</head>
<body>
	<div class="container">
	
		<jsp:include page="header.jsp"></jsp:include>
	
	
		 <form action="searchByName?method=searchCourse" method="post" name="searchByName">
                    课程名称：<input type="text" name="searchName" value="<c:out value="${searchName}"></c:out>">
         <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-success""  
         onclick="return checkSearch()"> 查找</button>&nbsp;&nbsp;
         <c:if test="${user.type==1 }">
         	<button type="submit" class="btn btn-success"><a href="addCourse.jsp" style="color:white">添加</a></button>
         </c:if>
        </form>
		<table  class="table table-hover table-condensed text-center" style="margin-top:10px">
		    <tr>
				<td align="center">
					<strong>编号</strong>
				</td>
				<td align="center">
					<strong>课名</strong>
				</td>
				<td align="center">
					<strong>类型</strong>
				</td>
				<td align="center">
					<strong>所属班级</strong>
				</td>
				<td align="center" >
					<strong>执行操作</strong>
				</td>
			</tr>
			<c:forEach items="${pageBean.data}" var="course">
				<tr>
					<td>
						<c:out value="${course.courseId}" />
					</td>
					<td>
						<c:out value="${course.coursename}" />
					</td>
					<td>
						<c:if test="${course.coursetype==1 }">必修</c:if>
						<c:if test="${course.coursetype==2 }">选修</c:if>
					</td>
					<td>
						<c:out value="${course.classname}" />
					</td>
					<td>
					<c:if test="${user.type==1}">
						<a href="deleteCourse?id=${course.courseId}" class="btn btn-danger" onclick="return checkDelete()">删除</a>
						<a href="updateCourse?method=updateUI&id=${course.courseId}" class="btn btn-primary">更新</a>		
					</c:if>
					<c:if test="${user.type==2}">
						<a href="SelectCourse?stuid=${user.stuid}&coursename=${course.coursename}" class="btn btn-primary">选课</a>
					</c:if>	
					<c:if test="${user.type==3}">
						无权限
					</c:if>
					</td>
				</tr>
			</c:forEach>
			<c:forEach items="${stuList}" var="course">
				<tr>
					<td>
						<c:out value="${course.courseId}" />
					</td>
					<td>
						<c:out value="${course.coursename}" />
					</td>
					<td>
						<c:if test="${course.coursetype==1 }">必修</c:if>
						<c:if test="${course.coursetype==2 }">选修</c:if>
					</td>
					<td>
						<c:out value="${course.classname}" />
					</td>
					<td>
					<c:if test="${user.type==1}">
						<a href="deleteCourse?id=${course.courseId}" class="btn btn-danger" onclick="return checkDelete()">删除</a>
						<a href="updateCourse?method=updateUI&id=${course.courseId}" class="btn btn-primary">更新</a>		
					</c:if>
					<c:if test="${user.type==2}">
						<a href="SelectCourse?stuid=${user.stuid}&coursename=${course.coursename}" class="btn btn-primary">选课</a>
					</c:if>	
					<c:if test="${user.type==3}">
						无权限
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>

		<nav class="text-center">
		  <ul class="pagination">
		    <li><a href="listStudent?pageNum=${pageBean.pageNum-1 }&pageSize=${pageBean.pageSize}" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
		    
		    <c:forEach begin="1" end="${pageBean.totalPage }" var="p" step="1">
		    		<c:if test="${p==pageBean.pageNum }">
		    			<li class="active"><a href="#">${p } <span class="sr-only">(current)</span></a></li>
		    		</c:if>
		    		<c:if test="${p!=pageBean.pageNum }">
		    			<li><a href="listStudent?pageNum=${p }&pageSize=${pageBean.pageSize}">${p }</a></li>
		    		</c:if>
		    		
		    </c:forEach>
		    
		    <li><a href="listStudent?pageNum=${pageBean.pageNum+1 }&pageSize=${pageBean.pageSize}" aria-label="Next"><span aria-hidden="true">»</span></a></li>
		     <li style="line-height: 35px">&nbsp;&nbsp;共 ${pageBean.totalPage }页,当前第 ${pageBean.pageNum} 页</li>
		  </ul>
		</nav>

		<hr>
		<a href="main.jsp" class="btn btn-success">返回主菜单</a>
		<hr>
		<script type="text/javascript">
		function checkDelete(){
			return window.confirm("确定要删除吗?");
		}
		function checkSearch(){
			
		}
		
	</script>
	
	</div>
	
	

</body>
</html>