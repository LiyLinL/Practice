(function (global, factory) {
    global.test = factory();
})(this, function () {
    'use strict';

    var h = function () {
        return 'b';
    };

    function b(a, b, c) {
        return function (a, b, c) {
            console.log(a);
        };
    }

    function test() {
        return h.apply(null, arguments);
    }

    test.b = b;

    return test;
});
