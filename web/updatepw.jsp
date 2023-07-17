<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>后台管理-更新密码</title>

		<link rel="stylesheet" href="css/bootstrap.css" />
		<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<div class="container">
	
		<jsp:include page="header.jsp"></jsp:include>
		<form action="updatePw" class="form-signin"  method="post">
       
         <h2 class="form-signin-heading">修改密码</h2>
 			<table >
 				
 				<tr>
                <td >原始密码:</td>
                <td  ><input type="password" name="oldpassword" id="oldpassword" class="form-control"></td>
               </tr>
 			
               <tr>
                <td >新密码:</td>
                <td  ><input type="password" name="newpassword" id="newpassword" class="form-control"></td>
               </tr>
                
               <tr>
                <td >确定新密码:</td>
                <td ><input type="password" name="repassword" id="repassword" class="form-control"></td>
               </tr>
                
               <tr>
                
                 <td colspan="2">
                 	<input class="btn btn-primary" type="submit" value="修 改" onclick="return checkp()" />
                      <input type="reset" class="btn btn-success" value="清 除">
                 </td>
                 
               </tr>
            </table>
        
        </form>
	
	</div>
	
	<script type="text/javascript">
	
		function  checkp() {
			var oldp=$("#oldpassword").val();
			var p1=$("#newpassword").val();
			var p2=$("#repassword").val();
			if(oldp==null || oldp.trim()==""){
				alert("原始密码不能为空");
				return false;
			}
			
			if(p1==null || p1.trim()==""){
				alert("新密码不能为空");
				return false;
			}
			if(p1!=p2){
				alert("两次密码不一样");
				return false;
			}
			
			return window.confirm("确定要更新吗?");
		
			
		}
	</script>


</body>
</html>