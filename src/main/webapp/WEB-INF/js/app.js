define(['angular','angularAMD', 'angular-ui-router', 'angular-file-upload'], function(angular, angularAMD){
    var app = angular.module('app', ['ui.router', 'angularFileUpload']);
    app.config(function($stateProvider, $urlRouterProvider){
        $urlRouterProvider.otherwise('/message');
        $stateProvider
            .state('message', {
                url: '/message',
                views: {
                    'container@': angularAMD.route({
                        templateUrl: 'templates/upload.html',
                        controllerUrl: 'js/controllers/upload.js'
                    })
                }
            })
    });

    return angularAMD.bootstrap(app);
});

