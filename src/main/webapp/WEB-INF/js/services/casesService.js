define(['app'], function(app){
    app.factory('CasesService', function($http){
        var casesService = {
            test1: function(){
                console.log("test1测试成功！");
            }
        };
        return casesService;
    });
});