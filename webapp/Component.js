sap.ui.define(
    ['sap/ui/core/UIComponent', 'gen/core/BaseController', 'gen/core/base'],
    function (UIComponent, BaseController) {
        'use strict';
        return UIComponent.extend('gen.Component', {
            metadata: {
                manifest: 'json'
            },
            init: function () {
                var me = this;

                new base(me).include();

                UIComponent.prototype.init.apply(this, arguments);
                me.getRouter().initialize();
            }
        });
    }
);
