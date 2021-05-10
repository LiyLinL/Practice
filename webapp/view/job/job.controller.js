sap.ui.define(
    [
        'gen/core/BaseController',
        'sap/ui/model/json/JSONModel',
        'gen/view/job/taskDetail',
        'gen/formatter/formatter',
        'gen/view/job/jobApi'
    ],
    function (BaseController, JSONModel, TaskDetail, formatter) {
        'use strict';
        return BaseController.extend('gen.view.job.job', {
            formatter: formatter,
            onInit: function () {
                var self = this,
                    oView = this.getView();
                this.attachPatternMatched('job', self.onRouteMatched);
            },
            onAfterRendering: function () {
                var self = this;
                var a = new jobApi();
                self.api = new jobApi('http://192.168.137.8');
            },
            onRouteMatched: function (oEvent) {
                var self = this,
                    oView = self.getView();
                var req = oEvent.getParameter('arguments')['?req'];

                self.getView().setModel(
                    new JSONModel({
                        table: []
                    })
                );

                this.getTask();
            },
            getTask: function () {
                var self = this,
                    oData = self.getData();

                self.api.getJob(
                    function (res) {
                        oData.table = res;
                        oData.table.forEach((el) => {
                            let rule = el.schedulerRule.split(' ');
                            el.sec = rule[0];
                            el.min = rule[1];
                            el.hour = rule[2];
                            el.dayOfWeek = rule[3];
                            el.dayOfMonth = rule[4];
                            el.week = rule[5];
                            el.year = rule[6];
                            el.editAble = false;
                        });
                        self.refresh();
                    },
                    function (err) {}
                );
            },
            operation: function (status, oEvent) {
                var self = this,
                    oData = self.getData();

                var oSource = oEvent.getSource();
                var index = oSource.getBindingContext().sPath.split('/')[2];

                if (status == 'pause') {
                    self.api.pause(
                        function (res) {
                            oData.table[index].frozenStatus = '1';
                            self.refresh();
                        },
                        function (err) {}
                    );
                }

                if (status == 'resume') {
                    self.api.resume(
                        function (res) {
                            oData.table[index].frozenStatus = '0';
                            self.refresh();
                        },
                        function (err) {}
                    );
                }

                if (status == 'now') {
                    self.api.run(
                        function (res) {},
                        function (err) {}
                    );
                }

                if (status == 'upd') {
                    oData.table[index].editAble = true;
                    self.refresh();
                }

                if (status == 'save') {
                    var data = oData.table[index];
                    var cron = '';
                    cron = cron
                        .concat(data.sec)
                        .concat(' ')
                        .concat(data.min)
                        .concat(' ')
                        .concat(data.hour)
                        .concat(' ')
                        .concat(data.dayOfWeek)
                        .concat(' ')
                        .concat(data.dayOfMonth)
                        .concat(' ')
                        .concat(data.week);

                    if (data.year) {
                        cron = cron.concat(' ').concat(data.year);
                    }

                    var body = {
                        taskNo: data.taskName,
                        cron: cron
                    };

                    self.api.upd(
                        body,
                        function (res) {
                            oData.table[index].frozenStatus = '0';
                            oData.table[index].editAble = false;
                            self.refresh();
                        },
                        function (err) {}
                    );
                }
            },
            detail: function (oEvent) {
                var self = this;
                self.api.getDetail(
                    function (res) {
                        self.setSeq(res, 'seq');
                        new TaskDetail().showDialog(self, res);
                    },
                    function (err) {}
                );
            }
        });
    }
);
