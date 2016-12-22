
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href=css/bootstrap.min.css rel=stylesheet>
</head>
<body>
<%@include file="leftMenu.jsp" %>
<div class=container>
	<form class=form-signin role=form action="logout" method="post">
		<button class="btn btn-lg btn-primary btn-block" type=submit>Log out</button>
	</form>
</div>
</body>
</html>