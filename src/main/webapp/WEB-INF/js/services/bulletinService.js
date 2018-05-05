define(['app'], function(app){
    app.factory('BulletinService', function($http){
        var bulletinService = {
            queryResults: function(config){
                var promise = $http.get('queryResults', config).then(function(response){
                    return response.data;
                });
                return promise;
            },

            delResult: function(config){
                var promise = $http.get('delResult', config);
                return promise;
            },

            addBulletin: function(config){
                var promise = $http.get('upload_no_file', config).then(function(response){
                    return response.data;
                });
                return promise;
            }
        };

        return bulletinService;
    });
})