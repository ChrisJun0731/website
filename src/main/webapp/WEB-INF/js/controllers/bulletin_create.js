define(['../services/bulletinService.js'], function(){
    return['$scope', '$timeout', 'BulletinService', 'FileUploader', 'toastr', function($scope, $timeout, bulletinService, FileUploader, toastr){

        $scope.uploader = new FileUploader({});

        $scope.uploadAll = function(){

            var isValid = $scope.isUndefined();
            if(isValid == 'invalid'){
                return;
            }
            if($scope.uploader.queue.length != 0){
                $scope.uploader.uploadAll();
                $timeout(function(){
                    toastr.success('上传成功！');
                },2000);
            }else{
                var config = {params: {type1: $scope.$parent.type1, type2: $scope.$parent.type2, title: $scope.title, desc: $scope.desc}};
                bulletinService.addBulletin(config).then(function(rs){
                    if(rs.flag=="success"){
                        toastr.success('上传成功！');
                    }else{
                        toastr.error('上传失败！');
                    }
                });
            }
        };
        $scope.uploader.onBeforeUploadItem = function(item){
            item.url = 'upload?type1='+$scope.$parent.type1+"&type2="+$scope.$parent.type2+"&title="+$scope.title+"&desc="+$scope.desc;
        };

        $scope.uploadItem = function(item){
            $scope.isUndefined();
            item.onBeforeUpload = function(){
                this.url = 'upload?type1='+$scope.$parent.type1+"&type2="+$scope.$parent.type2+"&title="+$scope.title+"&desc="+$scope.desc;
            };
            item.upload();
            toastr.success('上传成功！');
        };

        $scope.isUndefined = function(){
            if($scope.$parent.type1 == 'news' || $scope.$parent.type1 == 'join'){
                if($scope.title == undefined || $scope.desc == undefined){
                    alert('请填写标题和描述内容！');
                    return 'invalid';
                }
            }
            if($scope.$parent.type1 == 'cases'){
                if($scope.title == undefined){
                    alert('请填写标题！');
                    return 'invalid';
                }
                if($scope.uploader.queue.length == 0){
                    alert('案例上传时，需先选择图片！');
                    return 'invalid';
                }
            }
        };

    }]
})