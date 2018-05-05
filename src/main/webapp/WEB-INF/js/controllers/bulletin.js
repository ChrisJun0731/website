define(['../services/bulletinService.js'], function(){
    return['$scope', 'BulletinService', function($scope, bulletinService){

        $scope.changeType2 = function(type1){
            switch(type1){
                case 'news':
                    $scope.typeNames = [
                        {'name':'公司新闻', 'val':'company'},
                        {'name':'行业动态', 'val':'industry'},
                        {'name':'员工风采', 'val':'staff'}
                    ];
                    $scope.type2 = 'company';
                    break;
                case 'cases':
                    $scope.typeNames = [
                        {'name':'办公空间', 'val':'office'},
                        {'name':'商业空间', 'val':'commercial'},
                        {'name':'餐饮空间', 'val':'restaurant'},
                        {'name':'酒店会所', 'val':'hotel'},
                        {'name':'教育机构', 'val':'education'}
                    ];
                    $scope.type2 = 'office';
                    break;
                case 'join':
                    $scope.typeNames = [
                        {'name':'人才培养', 'val':'p_train'}
                    ];
                    $scope.type2 = 'p_train';
                    break;
            }
        };

        $scope.type1 = 'news';
        $scope.changeType2($scope.type1);



    }];
});