require.config({
    baseUrl: "js",
    paths: {
        'angular': 'plugins/angular',
        'angular-ui-router': 'plugins/angular-ui-router',
        'angularAMD': 'plugins/angularAMD',
        'angular-file-upload': 'plugins/angular-file-upload',
        'ui-bootstrap': 'plugins/ui-bootstrap-tpls-2.5.0',
        'angular-animate': 'plugins/angular-animate',
        'angular-toastr': 'plugins/angular-toastr.tpls'
    },
    shim: {
        'angular': {
            deps: ['plugins/jquery'],
            exports: 'angular'
        },
        'angularAMD': ['angular'],
        'angular-ui-router': ['angular'],
        'angular-file-upload': ['angular'],
        'angular-animate': ['angular'],
        'ui-bootstrap': ['angular'],
        'angular-toastr': ['angular']
    },
    deps: ['app']
});