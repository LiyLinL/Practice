sap.ui.define(
    [
        'sap/ui/base/Object',
        'sap/ui/core/Fragment',
        'gen/fragment/TableSelectDialog',
        'gen/fragment/MultiTableSelectDialog'
    ],
    function (Object, Fragment, TableSelectDialog, MultiTableSelectDialog) {
        'use strict';

        return Object.extend('gen.view.kanban.setting.setting', {
            //開啟畫面
            open: function (me) {
                this.me = me;
                // 取得 開窗 control, fragment ID, control/element id
                var dialog = Fragment.byId('setting', 'settingDialog'); // settingDialog?
                // 檢查 二度開窗是否存在
                if (!dialog) {
                    // 不存在, 載入
                    Fragment.load({
                        name: 'gen.view.kanban.setting.setting',
                        type: 'XML',
                        controller: this,
                        // fragment id?
                        id: 'setting'
                    }).then((frag) => {
                        // kanban odata
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
                                setSo: [],
                                setRefreshFreq: 1,
                                auto: true,
                                itemList: [
                                    {
                                        item: 'A',
                                        description: 'TESE',
                                        prodType: 'X'
                                    }
                                ],
                                orderList: [
                                    {
                                        item: 'A',
                                        order: '123456',
                                        status: '可核發'
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
            itemDialog: function (oEvent) {
                var sData = this.dialog.getModel().getData();

                new TableSelectDialog().open(oEvent.getSource(), sData.itemList);
            },
            tokenUpdate: function (oEvent) {
                this.me.tokenUpdate(oEvent);
            },
            addToken: function (oEvent) {
                this.me.addToken(oEvent);
            },
            orderDialog: function (oEvent) {
                var sData = this.dialog.getModel().getData();

                new MultiTableSelectDialog().openDialog(
                    // getSource() 取得 event.target
                    oEvent.getSource(),
                    sData.orderList
                );
            },
            isAuto: function (oEvent) {
                var sData = this.dialog.getModel().getData(),
                    oSource = oEvent.getSource(),
                    selected = oEvent.getParameter('selected');

                sData.auto = selected;
                this.dialog.getModel().refresh();
            },
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
            stop: function () {
                this.dialog.destroy();
                this.dialog = null;
            }
        });
    }
);
