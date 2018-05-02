define(['../services/recruitService.js'], function(){

    return['$scope', 'RecruitService', function($scope, recruitService){
        Array.prototype.indexOf = function(val){
            for(var i=0; i<this.length; i++){
                if(this[i] == val){
                    return i;
                }
            }
            return -1;
        }

        Array.prototype.remove = function(val){
            var index = this.indexOf(val);
            if(index > -1){
                this.splice(index, 1);
            }
        }

        $scope.recruits = [
            {"position":"", "num": "", "site": ""}
        ];

        $scope.addRecruit = function(){
            $scope.recruits.push({"position":"", "num":"", "site": ""});
        };

        $scope.delRecruit = function(recruit){
            $scope.recruits.remove(recruit);
        };

        $scope.upload = function(){
            recruitService.upload($scope.recruits);
        };
    }];
});