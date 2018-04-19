require.config({
    baseUrl: "js",
    paths: {
        'angular': 'plugins/angular',
        'angular-ui-router': 'plugins/angular-ui-router',
        'angularAMD': 'plugins/angularAMD',
        'angular-file-upload': 'plugins/angular-file-upload'
    },
    shim: {
        'angular': {
            deps: ['plugins/jquery'],
            exports: 'angular'
        },
        'angularAMD': ['angular'],
        'angular-ui-router': ['angular'],
        'angular-file-upload': ['angular']
    },
    deps: ['app']
});