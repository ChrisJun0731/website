define(['app'], function(app){
    app.factory('UploadService', function($http){
        var uploadService = {
            queryResults: function(config){
                var promise = $http.get('queryResults', config).then(function(response){
                    return response.data;
                });
                return promise;
            },

            delResult: function(data){
                $http.get('delResult', data);
            }
        };

        return uploadService;
    });
})