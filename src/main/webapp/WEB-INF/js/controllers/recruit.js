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

        $scope.recruits = [];

        $scope.addRecruit = function(recruit){
            $scope.recruits.push(recruit);
        }

        $scope.removeRecruit = function(recruit){
            $scope.recruits.remove(recruit);
        }

        $scope.upload = function(){

        }
    }];
});