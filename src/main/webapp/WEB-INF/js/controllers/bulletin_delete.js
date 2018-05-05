define(['../services/bulletinService.js'], function(){
    return['$scope', 'BulletinService', function($scope, bulletinService){
        $scope.queryResults = function(){
            var config = {params: {type1: $scope.$parent.type1, type2: $scope.$parent.type2}}
            bulletinService.queryResults(config).then(function(data){
                $scope.results = data;
            });
        };

        $scope.delResult = function(title){
            var config = {params: {type1: $scope.$parent.type1, type2: $scope.$parent.type2, title:title}};
            bulletinService.delResult(config).then(function(){
                 return bulletinService.queryResults(config);
            }).then(function(data){
                $scope.results = data;
            });
        };
    }];
});