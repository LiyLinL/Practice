sap.ui.define(
    ['sap/ui/base/Object', 'sap/ui/core/Fragment', 'gen/fragment/TableSelectDialog'],
    function (Object, Fragment, TableSelectDialog) {
        'use strict';

        return Object.extend('gen.view.kanban.setting.setting', {
            //開啟畫面
            open: function (me) {
                this.me = me;
                var dialog = Fragment.byId('setting', 'settingDialog');

                if (!dialog) {
                    //未關閉時銷毀
                    Fragment.load({
                        name: 'gen.view.kanban.setting.setting',
                        type: 'XML',
                        controller: this,
                        id: 'setting'
                    }).then((frag) => {
                        var main = me.getData();

                        this.dialog = frag;
                        //製作新的fragment
                        this.dialog.setModel(me.getModel('i18n'), 'i18n');
                        this.dialog.setModel(
                            new sap.ui.model.json.JSONModel({
                                site: main.site,
                                planQty: '',
                                setItem: '',
                                setItemDesc: '',
                                setSo: '',
                                setRefreshFreq: 1,
                                auto: true,
                                itemList: [
                                    {
                                        item: 'A',
                                        description: 'TESE',
                                        prodType: 'X'
                                    }
                                ]
                            })
                        );
                        this.dialog.open();
                    });
                } else {
                    dialog.open();
                    this.dialog = dialog;
                }
                return this;
            },
            // 物料開窗
            itemDialog: function (oEvent) {
                var sData = this.dialog.getModel().getData();

                new TableSelectDialog().open(oEvent.getSource(), this.dialog, sData.itemList);
            },
            // 手動 or 自動
            isAuto: function (oEvent) {
                var sData = this.dialog.getModel().getData(),
                    oSource = oEvent.getSource(),
                    selected = oEvent.getParameter('selected');

                sData.auto = selected;
                this.dialog.getModel().refresh();
            },
            // 啟動
            start: function () {
                var mainData = this.me.getData(),
                    sData = this.dialog.getModel().getData();

                mainData.planQty = sData.planQty + ' / 0';
                mainData.item = sData.setItem;
                mainData.itemDesc = sData.setItemDesc;
                mainData.refreshFreq = sData.setRefreshFreq;
                mainData.isAuto = sData.auto;

                this.me.refresh();
                this.stop();
            },
            // 暫停
            stop: function () {
                this.dialog.destroy();
                this.dialog = null;
            }
        });
    }
);
