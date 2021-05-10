sap.ui.define(
    [
        'sap/ui/core/Fragment',
        'sap/ui/base/Object',
        'sap/ui/model/json/JSONModel',
        'gen/formatter/formatter'
    ],
    function (Fragment, Object, JSONModel, formatter) {
        'use strict';
        return Object.extend('gen.view.job.detail.taskDetail', {
            formatter: formatter,
            showDialog: function (self, data) {
                this.self = self;

                var dialog = Fragment.byId('taskDetail', 'taskDetail');

                if (dialog) {
                    dialog.destroy();
                    dialog = null;
                }

                if (!this.dialog) {
                    this.dialog = Fragment.load({
                        id: 'taskDetail',
                        name: 'gen.view.job.detail.taskDetail',
                        controller: this
                    }).then(function (oDialog) {
                        oDialog.setTitle('Task Detail');
                        return oDialog;
                    });
                }
                this.dialog.then(function (oDialog) {
                    oDialog.setModel(
                        new JSONModel({
                            detail: data
                        })
                    );
                    oDialog.setModel(self.getModel('i18n'), 'i18n');
                    oDialog.open();
                });
            },
            close: function () {
                this.dialog.then(function (oDialog) {
                    oDialog.destroy();
                });
            }
        });
    }
);
