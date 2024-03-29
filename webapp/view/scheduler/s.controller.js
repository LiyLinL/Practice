sap.ui.define(
    ['gen/core/BaseController', 'sap/ui/model/json/JSONModel'],
    function (BaseController, JSONModel) {
        'use strict';
        return BaseController.extend('gen.view.scheduler.s', {
            constructor: function () {},
            onInit: function () {
                var me = this,
                    oView = this.getView();
                this.attachPatternMatched('s', me.onRouteMatched);
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
                        yUnit: [
                            {
                                key: '1',
                                label: 'Test',
                                open: true,
                                children: [
                                    {
                                        key: '100202,EDM-09',
                                        label: 'EDM-09CNC線切割機_G32S_1616000205'
                                    }
                                ]
                            }
                        ],
                        detail: [
                            {
                                headKey: '100202,EDM-09',
                                start_date: '2021-04-22 11:45:00',
                                end_date: '2021-04-22 12:35:00'
                            }
                        ]
                    })
                );
            },
            test: function (oEvent) {
                var me = this;

                var s = me.byId('sched');
            }
        });
    }
);
