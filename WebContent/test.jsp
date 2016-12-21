<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JS Bin</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.5/angular.min.js"></script>
</head>
<body>
  數量: <input type="number" ng-model="quantity" ng-init="quantity = 1">
  <br>
  單價: <input type="number" ng-model="price" ng-init="price = 299">
  <br>
  總價: {{ quantity * price }}
  
<h1><%=request.getAttribute("result") %></h1>
<form action="test3" method="get">
	<input type="submit" value="log out" />
</form>
</body>
</html>