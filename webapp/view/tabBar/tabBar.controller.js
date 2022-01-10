sap.ui.define(['gen/core/BaseController'], function (BaseController) {
    'use strict';
    return BaseController.extend('gen.view.tabBar.tabBar', {
        onInit: function () {
            var me = this;
            var oView = this.getView();
        },
        test: function () {
            var a = this.getView().byId('tabBar');

            var b = this.getView().byId('kanban').byId('ins');
        }
    });
});
