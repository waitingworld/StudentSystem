<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp" ng-controller="AngularController">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    pageContext.setAttribute("basePath",basePath);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="<%=basePath%>/app/css/bootstrap.css" rel="stylesheet">

    <script type="text/javascript" src="<%=basePath%>/app/js/angular.js"></script>
    <script type="text/javascript" src="<%=basePath%>/app/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>/app/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/app/js/Math.uuid.js"></script>
    <script type="text/javascript" src="<%=basePath%>/app/controller/AngularController.js"></script>
    <%--<script type="text/javascript" src="<%=basePath%>/app/service/dataService.js"></script>--%>
    <title>AngularJSTest1</title>
</head>
<body>
<p>User</p>
<p>ID</p>
<input ng-model="aaa">
<br>
<p>Name</p>
<input name="name">
<br>
<p>age</p>
<input name="age">
<br>
<button>提交</button>
</body>
</html>