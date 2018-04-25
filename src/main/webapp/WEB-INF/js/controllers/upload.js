define(['../services/uploadService.js'], function(){
    return['$scope', 'UploadService', 'FileUploader', function($scope, uploadService, FileUploader){
        $scope.uploader = new FileUploader({});
        $scope.uploadAll = function(){
//            console.log("type is" + $scope.type + ",title is " + $scope.title + ",desc is " + $scope.desc);
//            $scope.url = 'upload?type='+$scope.type+"&title="+$scope.title+"&desc="+$scope.desc;
//            $scope.uploader.url = $scope.url;
            $scope.uploader.uploadAll();
        };
        $scope.uploader.onBeforeUploadItem = function(item){
            console.log("type is" + $scope.type + ",title is " + $scope.title + ",desc is " + $scope.desc);
            item.url = 'upload?type='+$scope.type+"&title="+$scope.title+"&desc="+$scope.desc;
        }
    }];
});