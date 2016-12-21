
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href=css/bootstrap.min.css rel=stylesheet>
<link href=css/login.css rel=stylesheet>
</head>
<body>
<div class=container>
	<form class=form-signin role=form action="login" method="post">
		<h2 class=form-signin-heading>Please sign in</h2>
		<input type=email name="email" id=inputEmail class=form-control placeholder="Email address" required autofocus value="andy@moregeek.com">
		<input type=password name="password" id=inputPassword class=form-control placeholder=Password required value="c4ca4238a0b923820dcc509a6f75849b">
		<button class="btn btn-lg btn-primary btn-block" type=submit>Sign in</button>
	</form>
</div>
</body>
</html>