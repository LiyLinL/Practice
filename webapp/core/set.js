(function (global, factory) {
    global.$setApi = factory();
})(this, function () {
    'use strict';

    let api;

    var set = function (name) {
        api = new ajax(name);
    };

    var get = function () {
        return api;
    };

    return {
        set: set,
        get: get
    };
});
