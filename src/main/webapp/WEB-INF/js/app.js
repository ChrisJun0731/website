define(['angular','angularAMD', 'angular-ui-router', 'angular-file-upload', 'ui-bootstrap', 'angular-toastr'],
    function(angular, angularAMD){
    var app = angular.module('app', ['ui.router', 'angularFileUpload', 'ui.bootstrap', 'toastr']);
    app.config(function($stateProvider, $urlRouterProvider){
        $urlRouterProvider.otherwise('/bulletin/create');
        $stateProvider
            .state('bulletin', {
                url: '/bulletin',
                views: {
                    'container@': angularAMD.route({
                        templateUrl: 'templates/bulletin.html',
                        controllerUrl: 'js/controllers/bulletin.js'
                    })
                }
            })
            .state('bulletin.create', angularAMD.route({
                url: '/create',
                templateUrl: 'templates/bulletin_create.html',
                controllerUrl: 'js/controllers/bulletin_create.js'
            }))
            .state('bulletin.delete', angularAMD.route({
                url: '/delete',
                templateUrl: 'templates/bulletin_delete.html',
                controllerUrl: 'js/controllers/bulletin_delete.js'
            }))
            .state("recruit", {
                url: '/recruit',
                views: {
                    'container@': angularAMD.route({
                        templateUrl: 'templates/recruit.html',
                        controllerUrl: 'js/controllers/recruit.js'
                    })
                }
            })
    });

    return angularAMD.bootstrap(app);
});

