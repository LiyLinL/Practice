sap.ui.define(
    [
        'gen/core/BaseController',
        'sap/ui/model/json/JSONModel',
        'gen/view/dialog/Dialog',
        'sap/ui/model/Filter',
        'sap/ui/model/FilterOperator',
        'gen/view/interface'
    ],
    function (BaseController, JSONModel, Dialog, Filter, FilterOperator) {
        'use strict';
        return BaseController.extend('gen.view.custom.custom', {
            onInit: function () {
                var me = this,
                    oView = this.getView();
                this.attachPatternMatched('custom', me.onRouteMatched);
            },
            onRouteMatched: function (oEvent) {
                var me = this,
                    oView = me.getView();
                var req = oEvent.getParameter('arguments')['?req'];
                me.getView().setModel(
                    new JSONModel({
                        table: []
                    })
                );

                const oData = me.getData();
                for (var k = 1; k < 11; k++) {
                    oData.table.push({
                        seq: k,
                        text: 'Table' + k
                    });
                }
                me.refresh();

                var it = new i('');
            },
            filter: function (oEvent) {
                var oColumn = oEvent.getParameter('column');
                var seq = this.byId('seq');
                if (oColumn != seq) {
                    return;
                }
                oEvent.preventDefault(); // 阻止原本事件

                var clear = function () {
                    oColumn.setFiltered(false);
                    this.byId('table').getBinding().filter(null);
                };

                var sValue = oEvent.getParameter('value');
                if (!sValue) {
                    clear.apply(this);
                    return;
                }
                var value = parseInt(sValue);
                var f = new Filter('seq', FilterOperator.EQ, value);
                oColumn.setFiltered(true);
                //Control
                //Application
                this.byId('table').getBinding().filter(f);
            },
            dialogOpen: function (oEvent, id) {
                this.byId('Dialog').open();
            },
            close: function (oEvent) {
                this.byId('Dialog').close();
            }
        });
    }
);
