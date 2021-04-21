sap.ui.define(
    [
        'gen/core/BaseController',
        'sap/ui/model/json/JSONModel',
        'gen/view/dialog/Dialog',
        'sap/ui/model/Filter',
        'sap/ui/model/FilterOperator',
        'gen/view/test/interface'
    ],
    function (BaseController, JSONModel, Dialog, Filter, FilterOperator) {
        'use strict';
        return BaseController.extend('gen.view.test.test', {
            onInit: function () {
                var me = this,
                    oView = this.getView();
                this.attachPatternMatched('test', me.onRouteMatched);
            },
            onAfterRendering: function () {
                // var s = new fw.Scheduler.Scheduler({
                //     id: 'test',
                //     name: 'test',
                //     yUnit: [
                //         { key: 1, label: 'James Smith' },
                //         { key: 2, label: 'John Williams' },
                //         { key: 3, label: 'David Miller' },
                //         { key: 4, label: 'Linda Brown' }
                //     ],
                //     detail: [
                //         {
                //             start_date: '2021-03-23 09:00:00',
                //             end_date: '2021-03-23 12:00:00',
                //             text: 'Task A-12458',
                //             headKey: 1
                //         }
                //     ],
                //     eventOnDblclick: true
                // });
                // this.byId('div').addItem(s);
            },
            onRouteMatched: function (oEvent) {
                var me = this,
                    oView = me.getView();
                var req = oEvent.getParameter('arguments')['?req'];
                me.getView().setModel(
                    new JSONModel({
                        test: '',
                        table: [
                            {
                                seq: 1,
                                text: 'A'
                            },
                            {
                                seq: 1,
                                text: 'C'
                            },
                            {
                                seq: 2,
                                text: 'B'
                            },
                            {
                                seq: 3,
                                text: 'B'
                            }
                        ],
                        yUnit: [],
                        detail: []
                    })
                );

                var a = new i('test');
                console.log(a.editName(111).name);
            },
            test: function (oEvent) {
                var me = this,
                    oData = me.getData();

                oData.detail = [
                    {
                        start_date: '2021-04-08 09:00:00',
                        end_date: '2021-04-08 12:00:00',
                        text: 'Task A-12458',
                        headKey: 1
                    }
                ];

                me.refresh();
            },
            testF: function (oEvent) {
                var oColumn = oEvent.getParameter('column');
                var c = this.byId('s');
                if (oColumn != c) {
                    return;
                }
                oEvent.preventDefault(); // 阻止原本事件

                var clear = function () {
                    oColumn.setFiltered(false);
                    this.byId('table').getBinding().filter(null, 'Application');
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
                this.byId('table').getBinding().filter(f, 'Application');
            },
            pressTest: function (oEvent, id) {
                var c = this.byId('Dialog').open();
                // new Dialog(this).showDialog();
            },
            actPress: function (oEvent) {
                var e = oEvent;
            },
            close: function () {
                this.byId('Dialog').close();
                // this.byId('ip').setValue('');
            }
        });
    }
);
