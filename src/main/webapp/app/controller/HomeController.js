var homeApp = angular.module('homeApp', []);
homeApp.controller('HomeController', ['$scope', 'dataService', function ($scope, dataService) {
    // Math.uuid().replace(new RegExp("-","g"),"");//g,表示全部替换
    console.log("HomeController");
    $scope.currentShowType = "student";
    $scope.addDataInfo = {};
    $scope.searchModel={};
    $scope.scores = [];
    $scope.students = [];
    $scope.disciplines = [];
    /*$scope.scores = [{
        student_code: 180103,
        discipline_code: 180001,
        discipline_name: '通信工程',
        student_name: '小明',
        score: 98,
        score_credit: 2
    },
        {
            student_code: 180102,
            discipline_code: 180001,
            discipline_name: '通信工程',
            student_name: '小明',
            score: 98,
            score_credit: 2
        },
        {
            student_code: 180104,
            discipline_code: 180001,
            discipline_name: '通信工程',
            student_name: '小明',
            score: 98,
            score_credit: 2
        },
        {
            student_code: 180105,
            discipline_code: 180001,
            discipline_name: '通信工程',
            student_name: '小明',
            score: 98,
            score_credit: 2
        }];
    $scope.students = [{
        code: '180101001',
        name: '小明',
        sex: '男',
        birthday: '1995-12-05',
        class_name: '通信一班',
        profession_name: '通信工程'
    }, {
        code: '180101001',
        name: '小明',
        sex: '男',
        birthday: '1995-12-05',
        class_name: '通信一班',
        profession_name: '通信工程'
    }, {
        code: '180101001',
        name: '小明',
        sex: '男',
        birthday: '1995-12-05',
        class_name: '通信一班',
        profession_name: '通信工程'
    }];
    $scope.disciplines = [{
        code: '180001',
        profession_name: '通信工程',
        name: '通信原理',
        type: '必修',
        open_time: '2018-02-01',
        period: '25',
        credit: '2'
    }, {
        code: '180002',
        profession_name: '通信工程',
        name: '通信原理',
        type: '必修',
        open_time: '2018-02-01',
        period: '25',
        credit: '2'
    }];*/
    $scope.changeShowTable = function (type) {
        $scope.currentShowType = type;
        $scope.getData(type);
    }
    $scope.deleteData = function (model, type) {
        var postData = {
            id: model.id,
            type: type
        }
        debugger
        var promis = dataService.sendData("main/deleteData", postData);
        promis.then(function (data) {
            debugger
            console.log(data);
            if (data.success) {
                alert("删除成功");
                $scope.getData(type);
            }
        });
    }
    $scope.updateData = function (model, type) {
        var postData = {
            model: model,
            type: type
        }
        var promis = dataService.sendData("main/updateData", postData);
        promis.then(function (data) {
            debugger
            console.log(data);
            if (data.success) {
                alert("更新成功");
                $scope.getData(type);
            } else if (angular.isDefined(data.msg)) {
                alert(data.msg);
            }
        });
    }
    $scope.addData = function (model, type) {
        debugger
        var postData = {
            type: type,
            model: model
        }
        var promis = dataService.sendData("main/insertData", postData);
        promis.then(function (data) {
            if (data.success) {
                alert("添加成功");
                $scope.getData(type);
                $scope.addDataInfo = {};
            }
        });
    }
    $scope.closeModal = function () {
        $scope.addDataInfo = {};
    }
    $scope.getData = function (type) {
        var postData = {
            type: type
        }
        var promis = dataService.sendData("main/getData", postData);
        promis.then(function (data) {
            debugger
            console.log(data);
            if (data.success) {
                switch (type) {
                    case "student":
                        $scope.students = data.model;
                        break;
                    case "discipline":
                        $scope.disciplines = data.model;
                        break;
                    case "score":
                        $scope.scores = data.model;
                        break;
                }
            }
        });

    }
    $scope.count = function (studentId) {
        var startTime = prompt("请输入学期开始时间(e.g:2018-01-01),可点击取消查询全部学分", "");
        var endTime = prompt("请输入学期结束时间(e.g:2018-01-01),可点击取消查询全部学分", "");
        debugger
        var postData = {
            id: studentId
        };
        if (angular.isDefined(startTime) && angular.isDefined(endTime)
            && startTime != null && endTime != null && startTime != "" && endTime != "") {
            postData.startTime = startTime;
            postData.endTime = endTime;
        }
        var promis = dataService.sendData("main/count", postData);
        promis.then(function (data) {
            if (data.success) {
                alert("该学生在指定学期获取的总学分为：" + data.source + "分！");
            }
        });
    };

    $scope.searchData = function () {//查询功能
        var postData = angular.copy($scope.searchModel);
        $scope.searchModel = {};
        postData.type = $scope.currentShowType;
        var promis = dataService.sendData("main/searchData", postData);
        promis.then(function (data) {
            if (data.success) {
                console.log(data);
                debugger
                var dataArray = [];
                dataArray.push(data);
                switch ($scope.currentShowType) {
                    case "student":
                        $scope.students = dataArray;
                        break;
                    case "discipline":
                        $scope.disciplines = dataArray;
                        break;
                    case "score":
                        $scope.scores = dataArray;
                        break;
                }
            }
        });
    }
    $scope.getData($scope.currentShowType);//默认显示学生
}]);