(function (global, factory) {
    global.$fn = factory();
})(this, function () {
    'use strict';

    var api = $setApi.get();

    var get = function (fn1, fn2) {
        api.get(
            '',
            'html',
            function () {
                fn1();
            },
            function () {
                fn2();
            }
        );
    };

    return {
        get: get
    };
});
