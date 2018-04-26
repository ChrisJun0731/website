define(['../services/uploadService.js'], function(){
    return['$scope', 'UploadService', 'FileUploader', function($scope, uploadService, FileUploader){
        $scope.uploader = new FileUploader({});
        $scope.uploadAll = function(){
            $scope.uploader.uploadAll();
        };
        $scope.uploader.onBeforeUploadItem = function(item){
            console.log("type is" + $scope.type + ",title is " + $scope.title + ",desc is " + $scope.desc);
            item.url = 'upload?type1='+$scope.type+"&type2="+$scope.type2+"&title="+$scope.title+"&desc="+$scope.desc;
        };

        $scope.changeType2 = function(type1){
            switch(type1){
                case 'news':
                    $scope.typeNames = [
                        {'name':'公司新闻', 'val':'company'},
                        {'name':'行业动态', 'val':'industry'},
                        {'name':'员工风采', 'val':'staff'}
                    ];
                    break;
                case 'cases':
                    $scope.typeNames = [
                        {'name':'办公空间', 'val':'office'},
                        {'name':'商业空间', 'val':'commercial'},
                        {'name':'餐饮空间', 'val':'restaurant'},
                        {'name':'酒店会所', 'val':'hotel'},
                        {'name':'教育机构', 'val':'education'}
                    ];
                case 'join':
                    $scope.typeNames = [
                        {'name':'人才培养', 'val':'p_train'}
                    ];
            }
        }


    }];
});