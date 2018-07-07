var myApp = angular.module('myApp', []);
myApp.controller('AngularController', ['$scope', function ($scope) {
    console.log("1230");
    $scope.aaa = Math.uuid().replace(new RegExp("-","g"),"");//g,表示全部替换
}]);