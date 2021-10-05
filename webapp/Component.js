sap.ui.define(
    ['sap/ui/core/UIComponent', 'gen/core/base', 'gen/ajax', 'gen/core/set'],
    function (UIComponent) {
        'use strict';
        return UIComponent.extend('gen.Component', {
            metadata: {
                manifest: 'json'
            },
            init: function () {
                var me = this;

                new base(me).include().load();

                UIComponent.prototype.init.apply(this, arguments);
                me.getRouter().initialize();
            }
        });
    }
);
