define(['../services/casesService.js'], function(){
    return["$scope", "CasesService", "FileUploader", function($scope, casesService, fileUploader){
        $scope.test = function(){
            console.log('测试成功');
        }
        $scope.test1 = function(){
            casesService.test1();
        }

    }]
})