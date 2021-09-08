sap.ui.define(['sap/ui/core/ComponentContainer'], function (ComponentContainer) {
    'use strict';

    $().ready(function () {
        //避免頁面保留cache
        $.ajaxSetup({
            cache: false
        });
    });

    new ComponentContainer({
        height: '100%',
        name: 'gen',
        settings: {
            id: 'gen'
        },
        async: true
    }).placeAt('content');
});
