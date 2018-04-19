define(['angular','angularAMD', 'angular-ui-router', 'angular-file-upload'], function(angular, angularAMD){
    var app = angular.module('app', ['ui.router', 'angularFileUpload']);
    app.config(function($stateProvider, $urlRouterProvider){
        $urlRouterProvider.otherwise('/news');
        $stateProvider
            .state('news', {
                url: '/news',
                views: {
                    'container@': angularAMD.route({
                        templateUrl: 'templates/news.html',
                        controllerUrl: 'js/controllers/news.js'
                    })
                }
            })
            .state('cases', {
                url: '/cases',
                views: {
                    'container@': angularAMD.route({
                        templateUrl: 'templates/cases.html',
                        controllerUrl: 'js/controllers/cases.js'
                    })
                }
            })
    });

    return angularAMD.bootstrap(app);
});

