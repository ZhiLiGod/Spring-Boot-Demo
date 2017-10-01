<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<title>Register</title>
</head>
<script type="text/javascript">
	function ifexist(){
		
		var username = $('#username').val();
		//alert(username);
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/findUserByUsername",
			contenType:"application/x-www-form-urlen",
			data:"username="+username,
			success:function(data){
				
				if(data){
					$("#btn").removeClass("btn disabled btn-block").addClass("btn btn-default btn-block");
					$("#msg").html("<font color='green'><b>Correct</b></font>");
					$("#btn").removeAttr("disabled");
				}else{
					$("#btn").removeClass("btn btn-default btn-block").addClass("btn disabled btn-block");
					$("#msg").html("<font color='red'><b>Name is being used</b></font>");
					$("#btn").attr("disabled", "disabled");
				}
				
			}
		});
	}
</script>
<body>
	<h1 class="page-header">Register</h1>
	<div class="container">
	<div class="col-md-6 col-md-offset-3">
	<form class="form-horizontal" action="${pageContext.request.contextPath}/userRegister" method="post">
		<span>${errMsg }</span><br/>
		Username: <input value="${user.name }" id="username" class="form-control" type="text" name="name" onblur="ifexist()" />
		<span id="msg"></span><br/><br/>		
		<input id="btn" class="btn btn-default btn-block" type="submit" value="Register" />
		<input class="btn btn-primary btn-block" type="reset" value="Reset" />
		
	</form>
	</div>
	</div>
</body>
</html>