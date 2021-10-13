sap.ui.define([
    'fw/core/BaseController',
    'sap/ui/model/Filter',
    'sap/ui/model/json/JSONModel'
], function (BaseController, Filter, JSONModel) {
    "use strict";
    return BaseController.extend("fw.fragment.TableSelectDialog", {
        /**
         * 
         * @param {} oSource input的物件
         * @param {} oModel 綁定的json資料
         * @param {} myfunction 確定後執行的function
         */
        open: function (oSource, oModel, myfunction) {
            //input的元件
            this.oSource = oSource;
            //確定或點選呼叫的function
            this.myfunction = myfunction;
            //過濾用的key
            this.filterKey = oSource.data("filterKey");
            //要返回的key
            this.callBackKey = oSource.data("callBackKey");
            //欄位設定 key|i18n;...
            this.columns = oSource.data("columns");
            //標題i18n
            this.title = oSource.data("title");
            //root
            this.root = oSource.data("root");
            //設定多選
            this.multiple = oSource.data("multiple") === "true" ? true : false;
            //設定全選
            this.selected = oSource.data("selected") === "true" ? true : false;
            //設定彈出框架構
            if (!this.dialog) { //該彈出框的設定
                this.dialog = sap.ui.xmlfragment(
                    "fw.fragment.TableSelectDialog",
                    this
                );
                //開窗依附在input
                oSource.addDependent(this.dialog);
            }
            //設定開窗的i18n model
            this.dialog.setModel(oSource.getModel("i18n"), "i18n");
            //取得i18n
            var oBundle = oSource.getModel("i18n").getResourceBundle();
            //設定標題
            if (this.title) {
                this.dialog.setTitle(oBundle.getText("g.select") + oBundle.getText(this.title));
            }
            //銷毀之前的欄位
            this.dialog.destroyColumns();
            //綁定的欄位資料
            var cell = [];
            if (this.columns) {
                for (let column of this.columns.split(";")) {
                    let separate = column.split("|");
                    //標頭的label
                    let label = new sap.m.Label({
                        text: oBundle.getText(separate[1])
                    });
                    //設定每行的標頭
                    this.dialog.addColumn(new sap.m.Column({
                        header: label
                    }));
                    //欄位綁定的資料
                    cell.push(new sap.m.Text({
                        text: "{" + separate[0] + "}"
                    }));
                }
            }
            //設定table的欄位
            var oTableItems = new sap.m.ColumnListItem({
                selected: this.selected,
                cells: cell
            });
            //設定綁定的搜尋物件
            if (this.dialog.getBinding("items")) {
                this.dialog.getBinding("items").filter([new Filter(
                    this.filterKey,
                    sap.ui.model.FilterOperator.Contains,
                    this.oSource.getValue()
                )]);
            }
            //設定root和cell
            this.dialog.bindAggregation("items", this.root, oTableItems);
            //設定多選
            this.dialog.setMultiSelect(this.multiple);
            //設定開窗的model
            this.dialog.setModel(new JSONModel(oModel));
            //開啟彈出框
            this.dialog.open();
            //設定確定或取消的樣式
            if (this.multiple) {
                document.getElementById(this.dialog.sId + "-ok-inner").className = "sapMBtnEmphasized sapMBtnHoverable sapMBtnInner sapMBtnText sapMFocusable";
            } else {
                document.getElementById(this.dialog.sId + "-cancel-inner").className = "sapMBtnEmphasized sapMBtnHoverable sapMBtnInner sapMBtnText sapMFocusable";
            }
            //回傳開窗物件
            return this.dialog;
        },
        //回傳table物件
        getTable: function () {
            return this.dialog.mAggregations._dialog.mAggregations.content[1];
        },
        /**
         * 設定寬度
         */
        setDialogContentWidth: function (evt) {
            this.dialog.setContentWidth(evt);
        },
        /**
         * 檢索
         */
        search: function (oEvent) {
            var sValue = oEvent.getParameter("value");
            var oFilter = new Filter(
                this.filterKey,
                sap.ui.model.FilterOperator.Contains, sValue
            );
            if (oEvent.getSource().getBinding("items")) {
                oEvent.getSource().getBinding("items").filter([oFilter]);
            }
        },
        /**
         * 確定
         */
        confirm: function (oEvent) {
            //取得選擇的資料
            var data = oEvent
                .getParameter("selectedContexts")
                .map(o => o.getObject());
            // 多選時設定input
            if (this.multiple) {
                this.callBackMulti(this.oSource, data);
            }
            //設定單選input
            else {
                this.oSource.setValue(data[0][this.callBackKey]);
            }
            //確定後執行的function
            if (this.myfunction) {
                this.myfunction(this.multiple ? data : data[0]);
            }
        },
        //多選的返回動作
        callBackMulti: function (input, data) {
            var tokens = input.getAggregation('tokenizer').getBinding('tokens');
            var prefixPath = '';
            if (input.sParentAggregationName == 'cells') {
                prefixPath = tokens.oContext.sPath + "/";
            }
            var path = prefixPath ? prefixPath + tokens.sPath : tokens.sPath;
            tokens.oModel.setProperty(path, data);
        }
    });
});