<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="homeApp" ng-controller="HomeController">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    pageContext.setAttribute("basePath", basePath);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="<%=basePath%>/app/css/bootstrap.css" rel="stylesheet">

    <script type="text/javascript" src="<%=basePath%>/app/js/angular.js"></script>
    <script type="text/javascript" src="<%=basePath%>/app/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>/app/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/app/js/Math.uuid.js"></script>
    <script type="text/javascript" src="<%=basePath%>/app/controller/HomeController.js"></script>
    <script type="text/javascript" src="<%=basePath%>/app/service/dataService.js"></script>
    <title>学生信息管理系统</title>
    <style>
        .vertical-center{
            position: absolute;
            top: 20%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    </style>
</head>
<body>
<div class="text-center">
    <h1>学生信息管理系统</h1>
    <div>
        <button class="btn btn-default" ng-click="changeShowTable('student')">学生信息</button>
        <button class="btn btn-default" ng-click="changeShowTable('discipline')">课程信息</button>
        <button class="btn btn-default" ng-click="changeShowTable('score')">学生成绩</button>
    </div>
    <div style="width: 1700px;" class="center-block">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="vertical-center">
                <div class="modal-content" style="width: 1000px">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            添加信息
                        </h4>
                    </div>
                    <div class="modal-body">
                        <table ng-if="currentShowType=='student'" class="table table-striped table-hover table-bordered text-center">
                            <tr>
                                <td>学号</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.code"></td>
                                <td>姓名</td>
                                <td colspan="3"><input style="width: 100%;" type="text" ng-model="addDataInfo.model.name"></td>
                            </tr>
                            <tr>
                                <td>性别</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.sex"></td>
                                <td>生日</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.birthday"></td>
                                <td>班级</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.class_name"></td>
                            </tr>
                        </table>
                        <table ng-if="currentShowType=='discipline'" class="table table-striped table-hover table-bordered text-center">
                            <tr>
                                <td>课程编号</td>
                                <td colspan="3"><input style="width: 100%;" type="text" ng-model="addDataInfo.model.code"></td>
                                <td>所属专业名称</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.profession_name"></td>
                                <td>课程名</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.name"></td>
                            </tr>
                            <tr>
                                <td>课程类型</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.type"></td>
                                <td>开课时间</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.open_time"></td>
                                <td>学时</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.period"></td>
                                <td>学分</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.credit"></td>
                            </tr>
                        </table>
                        <table ng-if="currentShowType=='score'" class="table table-striped table-hover table-bordered text-center">
                            <tr>
                                <td>学号</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.student_code"></td>
                                <td>课程号</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.discipline_code"></td>
                                <%--<td>课程名</td>--%>
                                <%--<td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.discipline_name"></td>--%>
                            </tr>
                            <tr>
                                <%--<td>学生姓名</td>--%>
                                <%--<td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.student_name"></td>--%>
                                <td>成绩</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.score"></td>
                                <td>学分</td>
                                <td><input style="width: 100%;" type="text" ng-model="addDataInfo.model.score_credit"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="closeModal()">
                            关闭
                        </button>
                        <button type="button" ng-click="addData(addDataInfo.model,currentShowType)" class="btn btn-default" data-dismiss="modal">
                            提交
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div ng-if="currentShowType=='student'"><input ng-model="searchModel.code" placeholder="请填写学号"><button class="btn btn-default" ng-click="searchData()">查询</button></div>
        <div ng-if="currentShowType=='discipline'"><input ng-model="searchModel.code" placeholder="请填写课程号"><button class="btn btn-default" ng-click="searchData()">查询</button></div>
        <div ng-if="currentShowType=='score'">
            <input ng-model="searchModel.student_code" placeholder="请填写学号">
            <input ng-model="searchModel.discipline_code" placeholder="请填写课程号">
            <button class="btn btn-default" ng-click="searchData()">查询</button>
        </div>

        <table ng-if="currentShowType=='student'" class="table table-striped table-hover table-bordered text-center">
            <thead>
            <tr>
                <td>序号</td>
                <td>学号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>生日</td>
                <td>班级</td>
                <td>专业</td>
                <td>操作<button class="btn btn-default btn-mini" data-toggle="modal" data-target="#myModal" ng-click="addDataInfo={}">添加</button></td>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="student in students">
                <td>{{$index+1}}</td>
                <td><input type="text" ng-model="student.code"></td>
                <td><input type="text" ng-model="student.name"></td>
                <td><input type="text" ng-model="student.sex"></td>
                <td><input type="text" ng-model="student.birthday"></td>
                <td><input type="text" ng-model="student.class_name"></td>
                <td><input type="text" ng-model="student.profession_name"></td>
                <td>
                    <button class="btn btn-default" ng-click="deleteData(student,currentShowType)">删除</button>
                    <button class="btn btn-default" ng-click="updateData(student,currentShowType)">修改</button>
                    <button class="btn btn-default" ng-click="count(student.id)">统计</button>
                </td>
            </tr>
            </tbody>
        </table>
        <table ng-if="currentShowType=='discipline'" class="table table-striped table-hover table-bordered text-center">
            <thead>
            <tr>
                <td>序号</td>
                <td>课程编号</td>
                <td>所属专业名称</td>
                <td>课程名</td>
                <td>课程类型</td>
                <td>开课时间</td>
                <td>学时</td>
                <td>学分</td>
                <td>操作<button class="btn btn-default btn-mini" data-toggle="modal" data-target="#myModal" ng-click="addDataInfo={}">添加</button></td>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="discipline in disciplines">
                <td>{{$index+1}}</td>
                <td><input type="text" ng-model="discipline.code"></td>
                <td><input type="text" ng-model="discipline.profession_name"></td>
                <td><input type="text" ng-model="discipline.name"></td>
                <td><input type="text" ng-model="discipline.type"></td>
                <td><input type="text" ng-model="discipline.open_time"></td>
                <td><input type="text" ng-model="discipline.period"></td>
                <td><input type="text" ng-model="discipline.credit"></td>
                <td>
                    <button class="btn btn-default" ng-click="deleteData(discipline,currentShowType)">删除</button>
                    <button class="btn btn-default" ng-click="updateData(discipline,currentShowType)">修改</button>
                </td>
            </tr>
            </tbody>
        </table>
        <table ng-if="currentShowType=='score'" class="table table-striped table-hover table-bordered text-center">
            <thead>
            <tr>
                <td>序号</td>
                <td>学号</td>
                <td>课程号</td>
                <td>课程名</td>
                <td>学生姓名</td>
                <td>成绩</td>
                <td>学分</td>
                <td>操作<button class="btn btn-default btn-mini" data-toggle="modal" data-target="#myModal" ng-click="addDataInfo={}">添加</button></td>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="score in scores">
                <td>{{$index+1}}</td>
                <td><input disabled type="text" ng-model="score.student_code"></td>
                <td><input disabled type="text" ng-model="score.discipline_code"></td>
                <td><input disabled type="text" ng-model="score.discipline_name"></td>
                <td><input disabled type="text" ng-model="score.student_name"></td>
                <td><input type="text" ng-model="score.score"></td>
                <td><input type="text" ng-model="score.score_credit"></td>
                <td>
                    <button class="btn btn-default" ng-click="deleteData(score,currentShowType)">删除</button>
                    <button class="btn btn-default" ng-click="updateData(score,currentShowType)">修改</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>