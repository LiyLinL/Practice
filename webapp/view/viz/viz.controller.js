sap.ui.define(
    ['gen/core/BaseController', 'sap/viz/ui5/format/ChartFormatter'],
    function (BaseController, ChartFormatter) {
        'use strict';
        return BaseController.extend('gen.view.viz.viz', {
            onInit: function () {
                var me = this;
                var oView = this.getView();

                var a = test;
                test.b('a');

                // 更改當前畫面配色
                sap.ui.getCore().applyTheme('sap_bluecrystal');

                this.getView().setModel(
                    new sap.ui.model.json.JSONModel({
                        milk: [
                            {
                                key: '1',
                                Supplies: 40,
                                Demands: 10,
                                Last: 50
                            },
                            {
                                key: '2',
                                Supplies: 10,
                                Demands: 60,
                                Last: 20
                            },
                            {
                                key: '3',
                                Supplies: 30,
                                Demands: 20,
                                Last: 10,
                                test: 'error'
                            }
                        ],
                        input1: 0,
                        input2: 0
                    })
                );

                var vizProperties = {
                    plotArea: {
                        dataLabel: {
                            visible: true
                        },
                        dataPointStyle: {
                            rules: [
                                {
                                    dataContext: [{ MeasureNamesDimension: 'Supplies' }],
                                    properties: {
                                        color: 'sapUiChartPaletteQualitativeHue2'
                                    },
                                    displayName: '在製量'
                                },
                                {
                                    dataContext: [{ MeasureNamesDimension: 'Demands' }],
                                    properties: {
                                        color: 'sapUiChartPaletteQualitativeHue3'
                                    },
                                    displayName: '良品量'
                                },
                                {
                                    dataContext: [{ MeasureNamesDimension: 'Last' }],
                                    properties: {
                                        color: 'sapUiChartPaletteQualitativeHue4'
                                    },
                                    displayName: '不良數'
                                },
                                {
                                    dataContext: [{ Supplies: { min: 40 } }],
                                    properties: {
                                        color: 'red'
                                    },
                                    displayName: '異常'
                                }
                            ]
                        }
                    },
                    categoryAxis: {
                        visible: true,
                        title: {
                            visible: false
                        },
                        label: {
                            style: {
                                color: 'blue'
                            }
                        }
                    },
                    valueAxis: {
                        visible: true,
                        title: {
                            visible: false
                        }
                    },
                    legend: {
                        visible: true,
                        title: {
                            text: 'legend',
                            visible: true
                        }
                    },
                    title: {
                        visible: true,
                        text: 'Test'
                    },
                    interaction: {
                        syncValueAxis: false
                    }
                };
                this.byId('idVizFrame').setVizType('column');
                this.byId('idVizFrame').setVizProperties(vizProperties);

                var that = this;
                this.interval1 = setInterval(() => {
                    var oData = that.getData();

                    oData.input1 = oData.input1 + 1;
                    me.refresh();
                }, 1000);

                this.interval2 = setInterval(() => {
                    var oData = that.getData();

                    oData.input2 = oData.input2 + 1;
                    me.refresh();
                }, 10000);
            },
            stop1: function () {
                clearInterval(this.interval1);
            }
        });
    }
);
