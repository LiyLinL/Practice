sap.ui.define(
    ['gen/core/BaseController', 'sap/viz/ui5/format/ChartFormatter', 'gen/view/kanban/setting/setting'],
    function (BaseController, ChartFormatter, setting) {
        'use strict';
        return BaseController.extend('gen.view.kanban.kanban', {
            onInit: function () {
                var me = this;
                var oView = this.getView();

                // 更改畫面配色
                sap.ui.getCore().applyTheme('sap_fiori_3_dark');

                var oData = this.setModel({
                    site: '1000',
                    user: '',
                    item: '',
                    itemDesc: '',
                    planQty: '500 / 0',
                    completionRate: '10%',
                    yieldRate: '5%',
                    prodVolume: '25',
                    ngQty: '1',
                    prodEfficiency: '15%',
                    refreshFreq: 1,
                    isAuto: true,
                    data: [
                        {
                            key: 'OP01',
                            inProd: 40,
                            prod: 20,
                            ngProd: 3
                        },
                        {
                            key: 'OP02',
                            inProd: 30,
                            prod: 15,
                            ngProd: 1
                        }
                    ]
                });

                // chart配置
                var vizProperties = {
                    plotArea: {
                        dataLabel: {
                            visible: true,
                            style: {
                                color: '#FFFFFF'
                            }
                        },
                        dataPointStyle: {
                            rules: [
                                {
                                    dataContext: [{ MeasureNamesDimension: 'inProd' }],
                                    properties: {
                                        color: 'sapUiChartPaletteSequentialHue1'
                                    },
                                    displayName: '在製量'
                                },
                                {
                                    dataContext: [{ MeasureNamesDimension: 'prod' }],
                                    properties: {
                                        color: 'sapUiChartPaletteSemanticGoodLight2'
                                    },
                                    displayName: '良品數'
                                },
                                {
                                    dataContext: [{ MeasureNamesDimension: 'ngProd' }],
                                    properties: {
                                        color: 'sapUiChartPaletteSemanticBadLight2'
                                    },
                                    displayName: '不良數'
                                }
                                // {
                                //     dataContext: [{ Supplies: { min: 40 } }],
                                //     properties: {
                                //         color: 'red'
                                //     },
                                //     displayName: '異常'
                                // }
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
                                color: '#FFFFFF'
                            }
                        }
                    },
                    valueAxis: {
                        visible: true,
                        title: {
                            visible: false
                        },
                        label: {
                            style: {
                                color: '#FFFFFF'
                            }
                        }
                    },
                    legend: {
                        visible: true,
                        drawingEffect: 'glossy',
                        title: {
                            text: 'legend',
                            visible: false
                        },
                        label: {
                            style: {
                                color: '#FFFFFF'
                            }
                        },
                        hoverShadow: {
                            color: '#ADADAD'
                        },
                        hoverSelectedShadow: {
                            color: '#E0E0E0'
                        }
                    },
                    title: {
                        visible: true,
                        text: 'WIP / 產出量',
                        style: {
                            color: '#FFFFFF'
                        }
                    },
                    interaction: {
                        syncValueAxis: false
                    }
                };
                this.byId('idVizFrame').setVizType('column');
                this.byId('idVizFrame').setVizProperties(vizProperties);
            },
            openSetting: function (oEvent) {
                new setting().open(this);
            }
        });
    }
);
