var homeApp = angular.module('homeApp');
homeApp.factory('dataService', ['$timeout', '$q', '$http', function ($timeout, $q, $http) {
    var factory = {};
    factory.sendData = function (url, params) {
        var defer = $q.defer();
        $http({
            url: url,
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            data: params,
        }).success(function (data) {
            defer.resolve(data);
        }).error(function (data, status, headers, config) {
            defer.reject(data);
        });
        return defer.promise;
    };
    return factory;
}]);