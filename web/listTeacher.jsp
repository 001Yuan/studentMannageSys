<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>后台管理-老师列表</title>

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
	
	
		 <form action="searchByName?method=searchTeacher" method="post" name="searchByName">
                    老师姓名：<input type="text" name="searchName" value="<c:out value="${searchName}"></c:out>">
         <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-success""  
         onclick="return checkSearch()"> 查找</button>&nbsp;&nbsp;
         <c:if test="${user.type==1 }">
         	<button type="submit" class="btn btn-success"><a href="addTeacher.jsp" style="color:white">添加</a></button>
         </c:if>
        </form>
		<table  class="table table-hover table-condensed text-center" style="margin-top:10px">
		    <tr>
				<td align="center">
					<strong>教师编号</strong>
				</td>
				<td align="center">
					<strong>姓名</strong>
				</td>
				<td align="center">
					<strong>性别</strong>
				</td>
				<td align="center">
					<strong>电话</strong>
				</td>
				<td align="center">
					<strong>地址</strong>
				</td>
				<td align="center" >
					<strong>执行操作</strong>
				</td>
			</tr>
			<c:forEach items="${pageBean.data}" var="teacher">
				<tr>
					<td>
						<c:out value="${teacher.tid}" />
					</td>
					<td>
						<c:out value="${teacher.tname}" />
					</td>
					<td>
						<c:out value="${teacher.tsex}" />
					</td>
					<td>
						<c:out value="${teacher.ttel}" />
					</td>
					<td>
						<c:out value="${teacher.taddress}" />
					</td>
					<td>
					
						<a href="deleteTeacher?tid=${teacher.tid}" class="btn btn-danger" onclick="return checkDelete()">删除</a>
						<a href="updateTeacher?method=updateUI&tid=${teacher.tid}" class="btn btn-primary">更新</a>
					
					
					</td>
				</tr>
			</c:forEach>
			<c:forEach items="${stuList}" var="teacher">
				<tr>
					<td>
						<c:out value="${teacher.tid}" />
					</td>
					<td>
						<c:out value="${teacher.tname}" />
					</td>
					<td>
						<c:out value="${teacher.tsex}" />
					</td>
					<td>
						<c:out value="${teacher.ttel}" />
					</td>
					<td>
						<c:out value="${teacher.taddress}" />
					</td>
					<td>
						<a href="deleteTeacher?tid=${teacher.tid}" class="btn btn-danger" onclick="return checkDelete()">删除</a>
						<a href="updateTeacher?method=updateUI&tid=${teacher.tid}" class="btn btn-primary">更新</a>
					</td>
				</tr>
			</c:forEach>
		</table>

		<nav class="text-center">
		  <ul class="pagination">
		    <li><a href="listTeacher?pageNum=${pageBean.pageNum-1 }&pageSize=${pageBean.pageSize}" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
		    
		    <c:forEach begin="1" end="${pageBean.totalPage }" var="p" step="1">
		    		<c:if test="${p==pageBean.pageNum }">
		    			<li class="active"><a href="#">${p } <span class="sr-only">(current)</span></a></li>
		    		</c:if>
		    		<c:if test="${p!=pageBean.pageNum }">
		    			<li><a href="listTeacher?pageNum=${p }&pageSize=${pageBean.pageSize}">${p }</a></li>
		    		</c:if>
		    		
		    </c:forEach>
		    
		    <li><a href="listTeacher?pageNum=${pageBean.pageNum+1 }&pageSize=${pageBean.pageSize}" aria-label="Next"><span aria-hidden="true">»</span></a></li>
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
		
	</script>
	
	</div>
	
	

</body>
</html>