define(['../services/recruitService.js'], function(){

    return['$scope', 'RecruitService', 'toastr',  function($scope, recruitService, toastr){
        Array.prototype.indexOf = function(val){
            for(var i=0; i<this.length; i++){
                if(this[i] == val){
                    return i;
                }
            }
            return -1;
        };

        Array.prototype.remove = function(val){
            var index = this.indexOf(val);
            if(index > -1){
                this.splice(index, 1);
            }
        };

        $scope.addRecruit = function(){
            $scope.recruits.push({"position":"", "num":"", "site": ""});
        };

        $scope.delRecruit = function(recruit){
            $scope.recruits.remove(recruit);
        };

        $scope.upload = function(){
            recruitService.upload($scope.recruits).then(function(rs){
                if(rs.flag == "success"){
                    toastr.success('招聘信息上传成功！');
                }else{
                    toastr.error('招聘信息上传失败！');
                }
            });
        };

        $scope.load = function(){
            recruitService.load().then(function(rs){
                if(rs.length == 0){
                    $scope.recruits = [{"position":"", "num": "", "site": ""}];
                }else{
                    $scope.recruits = rs;
                }
            });
        };

        $scope.load();
    }];
});