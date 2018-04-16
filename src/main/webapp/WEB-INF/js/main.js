require.config({
    baseUrl: "js",
    paths: {
        'angular': 'plugins/angular',
        'angular-ui-router': 'plugins/angular-ui-router',
        'angularAMD': 'plugins/angularAMD'
    },
    shim: {
        'angular': {
            deps: ['plugins/jquery'],
            exports: 'angular'
        },
        'angularAMD': ['angular'],
        'angular-ui-router': ['angular']
    },
    deps: ['app']
});