<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5" import="com.andy.system.util.SessionObj,com.andy.system.modelObj.IRole" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link href=css/bootstrap.min.css rel=stylesheet>
<script src=https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js></script>
<style>
</style>
</head>
<body>
	<%@include file="top.jsp" %>
	<jsp:include page="<%= SessionObj.getTargetPage(request.getSession()) %>" />
</body>
</html>