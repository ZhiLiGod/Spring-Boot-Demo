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
<title>Sign in</title>
</head>
<body>
	<h1 class="page-header">Sign in</h1>
	<div class="container">
	<div class="col-md-6 col-md-offset-3">
	<form class="form-horizontal" action="${pageContext.request.contextPath}/userLogin" method="post">
		<c:if test="${errors != null }">
			<c:forEach items="${errors }" var="error">
				<font color="red"><b>${error.defaultMessage }</b></font><br/>
			</c:forEach>
		</c:if>
		<font color="red"><b>${error }</b></font><br/>
		Username: <input class="form-control" type="text" name="name" /><br/>
		Password: <input class="form-control" type="password" name="password" /><br/>
		<input class="btn btn-default" type="submit" value="Sign in" />
		<input class="btn btn-primary" type="reset" value="Reset" />
		<input class="btn btn-info" value="Register" type="button" onclick="window.location.href='${pageContext.request.contextPath}/register'">
	</form>
	</div>
	</div>
</body>
</html>