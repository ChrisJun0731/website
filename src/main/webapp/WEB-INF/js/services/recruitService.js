define(['app'], function(app){
    app.factory('RecruitService', function($http){
        var recruitService = {

            upload: function(recruits){
                $http.post('/join', recruits);
            }

        };

        return recruitService;
    });
})