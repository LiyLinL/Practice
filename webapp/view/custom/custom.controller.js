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
                var c;
                var req = oEvent.getParameter('arguments');
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

                var I18N = this.getI18N();
                var c = I18N.getText('test.t', ['A', 'B', 'C']);

                this.export = function () {
                    var wb = new ExcelJS.Workbook();
                    var ws = wb.addWorksheet('sheet1');
                    ws.columns = [
                        { header: 'Id', key: 'id', width: 10 },
                        { header: 'Name', key: 'name', width: 32 },
                        { header: 'D.O.B.', key: 'DOB', width: 10, outlineLevel: 1 }
                    ];
                    ws.addRow({ id: 1, name: 'John Doe', dob: new Date(1970, 1, 1) });

                    ws.addTable({
                        name: 'sheet1',
                        ref: 'A3',
                        headerRow: true,
                        totalsRow: false,
                        style: {
                            theme: '',
                            showRowStripes: true
                        },
                        columns: [
                            { name: 'Id', filterButton: true },
                            { name: 'Name', filterButton: true },
                            { name: 'D.O.B.', filterButton: true }
                        ],
                        rows: [[1, 'Test', 'D']]
                    });

                    ws.addTable({
                        name: 'sheet1',
                        ref: 'A6',
                        headerRow: true,
                        totalsRow: false,
                        style: {
                            theme: '',
                            showRowStripes: true
                        },
                        columns: [
                            { name: 'Id', filterButton: true },
                            { name: 'Name', filterButton: true },
                            { name: 'D.O.B.', filterButton: true }
                        ],
                        rows: [[1, 'Test', 'D']]
                    });

                    ws.getCell('A1').border = {
                        top: { style: 'thin' },
                        left: { style: 'thin' },
                        bottom: { style: 'thin' },
                        right: { style: 'thin' }
                    };
                    ws.getCell('A1').fill = {
                        type: 'pattern',
                        pattern: 'solid',
                        fgColor: { argb: 'FFFFFF00' }
                    };

                    wb.xlsx.writeBuffer().then((data) => {
                        let blob = new Blob([data], {
                            type:
                                'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
                        });
                        saveAs(blob, 'test' + '-' + new Date().valueOf() + '.xlsx');
                    });
                };
            },
            filter: function (oEvent) {
                var self = this;
                var oColumn = oEvent.getParameter('column');
                var seq = this.byId('seq');
                if (oColumn != seq) {
                    return;
                }
                oEvent.preventDefault(); // 阻止原本事件

                var clear = function () {
                    oColumn.setFiltered(false);
                    self.byId('table').getBinding().filter(null);
                };

                var sValue = oEvent.getParameter('value');
                if (!sValue) {
                    clear();
                    return;
                }
                var value = parseInt(sValue);
                var f = new Filter('seq', FilterOperator.EQ, value);
                oColumn.setFiltered(true);
                //Control
                //Application
                this.byId('table').getBinding().filter(f);
            },
            actPress: function () {
                var table = this.getData().table;
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
