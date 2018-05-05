define(['app'], function(app){
    app.factory('RecruitService', function($http){
        var recruitService = {

            upload: function(recruits){
                var promise = $http.post('join/recruit', recruits).then(function(response){
                    return response.data;
                });
                return promise;
            },

            load: function(){
                var promise = $http.get('join/recruit').then(function(rs){
                    return rs.data;
                });
                return promise;
            }
        };

        return recruitService;
    });
})